package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel :ViewModel() {


    private var _userGuess by mutableStateOf("")
    val userGuess:String get()= _userGuess
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private var _currentWordCount = 1
    val currentWordCount: Int get() = _currentWordCount


    private var usedWord : MutableSet<String> = mutableSetOf()
    private lateinit var currentWord:String
    init {
        resetGame()
    }

    private fun pickRandomWordandShuffle():String{
        currentWord = allWords.random()
        if (usedWord.contains(currentWord)){
            return pickRandomWordandShuffle()
        }else{
            usedWord.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }

    }

    private fun shuffleCurrentWord(word:String):String{

        val tempWord = word.toCharArray()

        tempWord.shuffle()
        while(String(tempWord).equals(word)){
            tempWord.shuffle()
        }

        return String(tempWord)
    }

    fun resetGame(){
        usedWord.clear()
        _currentWordCount = 1
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordandShuffle())
    }

    fun updateUserGuess(guessedWord: String) {
        _userGuess = guessedWord

    }



    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)

        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)

            }


        }
        updateUserGuess("")

    }

    private fun updateGameState(updatedScore: Int) {


        if (usedWord.size == MAX_NO_OF_WORDS){
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }

        }else{
            _currentWordCount++
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordandShuffle(),
                    score = updatedScore,
                    currentWordCount = _currentWordCount
                )
            }
        }


    }

    fun skipWord() {
        updateGameState(_uiState.value.score)

        updateUserGuess("")
    }
}


