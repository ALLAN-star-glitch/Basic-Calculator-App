
# Simple Calculator App
# Overview
The Simple Calculator App is a basic Android calculator application built using Kotlin. It supports basic arithmetic operations including addition, subtraction, multiplication, and division. It also handles edge cases such as division by zero and shows error messages for invalid expressions.

## Features
1. Basic Operations: Addition, subtraction, multiplication, and division.
2. Error Handling: Displays "Error" for invalid expressions or arithmetic exceptions.
3. Clear Functionality: Allows users to clear the current expression or all input.
4. Backspace Functionality: Enables users to remove the last entered character.
5. Result Display: Shows the result of the calculation.
## Technologies Used
- Kotlin: Programming language for Android development.
- exp4j: Library for evaluating mathematical expressions.
- AndroidX: Android Jetpack libraries for modern Android development.
- Material Design: For UI components and styling.
## Screenshots

![Screenshot](https://dev-allanma.pantheonsite.io/wp-content/uploads/2024/08/WhatsApp-Image-2024-08-14-at-12.26.40-PM.jpeg)


## Installation
- Clone the repository:

```
git clone https://github.com/yourusername/calculatorapp.git
Open the project in Android Studio.
```

## Build and run the app:

- Connect an Android device or start an Android emulator.
- Click "Run" in Android Studio to build and install the app on the device.
## Usage
- Entering Numbers: Tap on the number buttons (0-9) to enter numbers.
- Using Operators: Tap on the operator buttons (+, -, *, /) to perform operations.
- Clearing Input: Tap the C button to clear the current input or A/C to clear all.
- Backspace: Tap the backspace button to remove the last character.
- Calculating Result: Tap the = button to calculate and display the result.
## Code Explanation
### MainActivity.kt:

Handles user interactions and performs calculations.
Manages different states such as errors, numeric input, and operations.
Uses the exp4j library to evaluate mathematical expressions.
### ActivityMain.xml:

Defines the layout of the calculator using ConstraintLayout and LinearLayouts.
Includes TextView for displaying input and result, and Button components for user interaction.
## Contributing
Feel free to fork the repository and make improvements or add new features. Submit pull requests for any changes you would like to contribute.
