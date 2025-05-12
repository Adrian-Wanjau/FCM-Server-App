# FCM Server App

## Overview
This is a Firebase Cloud Messaging (FCM) server application that allows sending push notifications to mobile devices. The server is built in Java and provides an API for sending notifications to devices registered with Firebase.

## Features
- Send notifications to specific devices using FCM tokens
- Support for both Android and iOS devices
- Configurable notification payloads
- Secure authentication with Firebase Admin SDK

## Prerequisites
- Java 11 or higher
- Maven for dependency management
- Firebase project with FCM enabled
- Service account credentials from Firebase

## Setup

### 1. Clone the repository
```bash
git clone https://github.com/Adrian-Wanjau/FCM-Server-app.git
cd FCM-Server-app
```

### 2. Firebase Configuration
1. Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
2. Generate a new private key for your service account:
   - Go to Project Settings > Service Accounts
   - Click "Generate New Private Key"
   - Save the JSON file as `service-account.json` in the project root directory

### 3. Build the application
```bash
mvn clean install
```

### 4. Run the server
```bash
java -jar target/fcm-server-app.jar
```

## Usage
The server exposes REST endpoints for sending notifications:

### Send notification to a specific device
```
POST /api/notifications
Content-Type: application/json

{
  "token": "DEVICE_FCM_TOKEN",
  "title": "Notification Title",
  "body": "Notification message body",
  "data": {
    "key1": "value1",
    "key2": "value2"
  }
}
```

## Security
- The service account file (`service-account.json`) contains sensitive credentials and should never be committed to version control
- The `.gitignore` file is configured to exclude sensitive files
- Use environment variables for production deployments

## License
[MIT License](LICENSE)

## Contact
For questions or support, please contact [your-email@example.com]
