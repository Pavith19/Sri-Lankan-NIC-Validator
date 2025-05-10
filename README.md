# Sri Lankan NIC Validator 🇱🇰✨

Welcome to the **Sri Lankan NIC Validator**! This Java application validates and extracts information from Sri Lankan National Identity Card (NIC) numbers, supporting both old (9 digits + letter) and new (12 digits) formats. 🎉

## Features 🌟
- Validates NIC numbers for correct format 📏
- Extracts key information:
  - Gender 🚻
  - Date of Birth 📅
  - Year of Birth 🎂
  - Day of Year 🔢
- Supports both old (e.g., `861234567V`) and new (e.g., `198612345678`) NIC formats 🔄
- User-friendly console interface with clear error messages 🖥️
- Built with clean, modular, and object-oriented Java code 🛠️

## How It Works ⚙️
The application uses a **strategy pattern** to process NIC numbers:
1. **NICProcessorFactory** determines the NIC format and creates the appropriate processor (`OldNICProcessor` or `NewNICProcessor`).
2. The processor validates the NIC and extracts information into a `NICInfo` object.
3. The console-based `SriLankanNICValidator` interacts with users, displaying results and handling inputs. 🖱️

## Getting Started 🚀

### Prerequisites
- Java Development Kit (JDK) 8 or higher ☕
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a terminal to compile and run the code 🖥️

### Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/Pavith19/sri-lankan-nic-validator.git
   ```
2. Navigate to the project directory:
   ```bash
   cd sri-lankan-nic-validator
   ```
3. Compile and run the application:
   ```bash
   javac *.java
   java SriLankanNICValidator
   ```

### Usage
1. Run the program and enter a Sri Lankan NIC number (old or new format).
2. View the extracted information (gender, date of birth, etc.).
3. Choose to validate another NIC or exit. 🥳

**Example Input/Output:**
```
Sri Lankan NIC Validator
========================
Enter your NIC number (old or new format) or type 'exit' to quit:
198612345678

NIC Information:
===============
Format: New (12 digits)
Gender: Male
Date of Birth: 1986-05-01
Year of Birth: 1986
Day of Year: 121

Do you want to validate another NIC? (Y/N)
```

## Project Structure 📂
- `SriLankanNICValidator.java`: Main application with console interface.
- `NICProcessor.java`: Interface for NIC processing strategy.
- `OldNICProcessor.java`: Handles old NIC format (9 digits + V/X).
- `NewNICProcessor.java`: Handles new NIC format (12 digits).
- `NICProcessorFactory.java`: Creates appropriate processor based on NIC format.
- `NICInfo.java`: Value object to store extracted NIC information.

## License 📜
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.



