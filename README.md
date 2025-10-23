# 🧩 Unscramble Game (My Improved Version)

This is my customized version of the **Unscramble Game** project — originally based on Google's Android Kotlin Compose training codelab.  
I’ve made improvements and fixes while learning about **Jetpack Compose**, **ViewModel**, **StateFlow**, and **unidirectional data flow (UDF)** architecture.

---

## 🚀 What I Learned & Improved
- Implemented **MVVM architecture** using `ViewModel` and `StateFlow`
- Managed **UI state** efficiently through immutable `GameUiState`
- Added **game logic**:
  - Random word selection and shuffling
  - User input handling (`updateUserGuess`, `checkUserGuess`, `skipWord`)
  - Score tracking and word counter
  - Game-over logic for last round
- Enhanced **UI feedback** with dynamic labels and error states (`isGuessedWordWrong`)
- Improved **Compose layout** for better readability and code separation

---

## 🧠 Tech Stack
- **Language:** Kotlin  
- **UI Toolkit:** Jetpack Compose  
- **Architecture:** MVVM + Unidirectional Data Flow  
- **State Management:** ViewModel + StateFlow  
- **IDE:** Android Studio

---

## 📸 Preview
<img src="https://github.com/mustafagelebek/UnscrambleGame/assets/example_screenshot.png" width="400"/>

---

## 💬 About This Version
This repository contains my personal modifications to the codelab project.  
All code changes were made for educational purposes as part of my Android development learning journey.

---

### 🧑‍💻 Author
**Mustafa Gelebek**  
Android Developer | Kotlin & Compose Learner  
🔗 [GitHub Profile](https://github.com/mustafagelebek)

---

### 📜 License
Based on the [Google Codelab Unscramble Game](https://github.com/google-developer-training/basic-android-kotlin-compose-training-unscramble).  
This version includes personal modifications and improvements.
