## Live Demo

🚀 **Deployed Application**: [https://androidprojectt.netlify.app/)


# 📱 Passwordless OTP Authentication – Android (Jetpack Compose)

## 📌 Project Overview
This project implements a **passwordless authentication flow** using **Email + OTP**, followed by a **session tracking screen**.  
All logic is implemented **locally**, without any backend, focusing on **state management, architecture, and Jetpack Compose best practices**.

---

## 🛠 Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: ViewModel + UI State (One-way data flow)
- **Concurrency**: Kotlin Coroutines
- **Analytics SDK**: Timber
- **IDE**: Android Studio

---

## ✨ Features

### 1. Email + OTP Login
- User enters an email address
- OTP is generated locally
- OTP length: **6 digits**

### 2. OTP Rules
- OTP expires after **60 seconds**
- Maximum **3 validation attempts**
- Generating a new OTP:
  - Invalidates old OTP
  - Resets attempt count
- OTP data is stored **per email**

### 3. Session Screen
- Displays:
  - Session start time
  - Live session duration (mm:ss)
- Logout button ends the session
- Timer:
  - Survives recompositions
  - Stops correctly on logout

### 4. Analytics Logging
Using **Timber**, the following events are logged:
- OTP generated
- OTP validation success
- OTP validation failure
- Logout

---

## 🧱 Project Architecture

│
├── ui
│ ├── LoginScreen.kt
│ ├── OtpScreen.kt
│ ├── SessionScreen.kt
│ └── theme
│
├── viewmodel
│ ├── AuthViewModel.kt
│ └── AuthState.kt
│
├── data
│ ├── OtpManager.kt
│ └── OtpData.kt
│
├── analytics
│ └── AnalyticsLogger.kt
│
└── MainActivity.kt


---

## 🔍 OTP Logic & Expiry Handling
- OTPs are generated using random 6-digit numbers.
- Each OTP is stored with:
  - OTP value
  - Expiry timestamp
  - Attempt counter
- Expiry is checked using `System.currentTimeMillis()`.
- OTP is invalidated if:
  - It expires
  - Attempts exceed the limit
  - Validation succeeds

---

## 📊 Data Structures Used
- `MutableMap<String, OtpData>`
  - **Key**: Email
  - **Value**: OTP details (OTP, expiry time, attempts)

### Why this approach?
- Fast lookup per email
- Easy OTP invalidation
- Clean separation of concerns
- Prevents global mutable state

---

## 🧠 State Management
- UI observes state via `StateFlow`
- ViewModel exposes immutable UI state
- UI sends events → ViewModel updates state → UI recomposes

This ensures:
- One-way data flow
- Recomposition safety
- Rotation-safe state handling

---

## 📦 External SDK Used

### Timber
**Why Timber?**
- Lightweight
- Easy to integrate
- Ideal for logging events during development

**Logged Events:**
- OTP generated
- OTP validation success
- OTP validation failure
- Logout

---

## 🤖 AI (GPT) Usage Disclosure
- Used GPT for:
  - Understanding architecture patterns
  - Clarifying Jetpack Compose concepts
  - Code structure guidance
- OTP logic, state management, and implementation were **understood and implemented manually**.

---

## ▶️ How to Run the Project
1. Clone the repository
2. Open in **Android Studio**
3. Let Gradle sync complete
4. Run on:
   - Android Emulator **or**
   - Physical Android device (USB debugging enabled)

---

## 🚫 What This Project Avoids
- No global mutable state
- No UI logic inside ViewModel
- No blocking calls on main thread
- No backend or network calls

---

## 📌 Evaluation Focus
- Code clarity & structure
- Correct state management
- Jetpack Compose usage
- Data structure reasoning
- SDK integration
- Documentation quality

---

## ✅ Conclusion
This project demonstrates a clean, scalable, and modern Android authentication flow using **Jetpack Compose**, **ViewModel-based architecture**, and **proper state management**, aligning with best practices.

