# Installation and Usage Guide

## Prerequisites
Before you can use this application, please ensure that you have Maven installed on your device. If you are using a Mac, you can install Maven using Homebrew by running the following command:

```shell
brew install maven
```

## Usage

1. **Navigate to the Application Directory**: Use your terminal or command prompt to navigate to the directory where the application is located.

2. **Navigate to the "target" Folder**: Once you are in the application directory, navigate to the "target" folder. This is where the compiled Java application and its JAR file are located.

3. **Execute the Application**: Run the application using the following command, replacing `"name of jar file"` with the actual name of the JAR file and `"CSV file location"` with the path to your CSV file. Here's an example command:

```shell
java -jar Assessment-0.0.1-SNAPSHOT.jar ../../basket.csv
```

Replace `"Assessment-0.0.1-SNAPSHOT.jar"` with the actual name of the JAR file you want to run and `"../../basket.csv"` with the actual path to your CSV file.

This command will execute the Java application, and it will process the CSV file according to the functionality.

Feel free to reach out if you have any questions or encounter any issues during the installation or usage of the application.