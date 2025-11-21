# Fitness-Tracker-App-using-Java-Swing

# Fitness Tracker App - Java Swing

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/GUI-Swing-blue)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

A comprehensive desktop application built with Java Swing for tracking fitness activities, monitoring workout progress, and achieving health goals.

## 📋 Table of Contents
- [Introduction](#introduction)
- [Key Features](#key-features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Introduction

The **Fitness Tracker App** is a Java GUI application designed to assist users in monitoring their daily physical activities and maintaining a healthy lifestyle. This application allows users to track important fitness metrics such as workout duration, distance covered, calories burned, and various exercise types. By offering an intuitive graphical interface, users can easily input and visualize their progress over time, helping them stay motivated and focused on their fitness goals.

Whether you're a fitness enthusiast, athlete, or someone just starting their health journey, this application provides the tools you need to log workouts, set achievable goals, and track your progress with detailed statistics and insights.

## ✨ Key Features

### 1. **Interactive Dashboard**
- Real-time statistics display with color-coded cards
- Visual overview of total workouts, calories burned, distance covered, and total duration
- Quick action buttons for seamless navigation
- Automatic updates when new data is added

### 2. **Comprehensive Workout Logging**
- Log multiple workout types: Running, Cycling, Swimming, Gym, Yoga, Walking, and more
- Track essential metrics for each workout:
  - Date and time
  - Workout type/category
  - Duration (in minutes)
  - Calories burned
  - Distance covered (in kilometers)
  - Additional notes
- View all workouts in an organized table format
- Delete unwanted workout entries

### 3. **Goal Setting & Progress Tracking**
- Create personalized fitness goals with target values
- Track current progress against set targets
- Visual progress percentage indicators
- Status updates (In Progress/Completed)
- Update progress values as you achieve milestones
- Manage multiple goals simultaneously

### 4. **Data Management**
- Add, view, and delete workout records
- Update goal progress dynamically
- Organized tabular view for easy data review
- Input validation to ensure data accuracy

### 5. **User-Friendly Interface**
- Clean and modern Swing GUI design
- Tabbed navigation for organized content access
- Dialog-based forms for easy data entry
- Responsive layout that adapts to window resizing
- Color-coded visual elements for better readability

### 6. **Statistics & Analytics**
- Cumulative totals for all tracked metrics
- Real-time dashboard updates
- Historical data preservation
- Easy-to-read summary cards

## 🖼️ Screenshots

### Dashboard View
The main dashboard displays key fitness statistics at a glance with color-coded cards.

### Workout Log
Track and manage all your workouts with detailed information including date, type, duration, and more.

### Goals Management
Set fitness goals and monitor your progress with percentage indicators and status updates.

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command-line tools

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/fitness-tracker-app.git
   cd fitness-tracker-app
   ```

2. **Compile the application**
   ```bash
   javac FitnessTrackerApp.java
   ```

3. **Run the application**
   ```bash
   java FitnessTrackerApp
   ```

### Alternative: Using an IDE
1. Open your preferred Java IDE
2. Import the project or open the `FitnessTrackerApp.java` file
3. Run the main method in the `FitnessTrackerApp` class

## 📖 Usage

### Adding a Workout
1. Navigate to the **Workouts** tab
2. Click the **"Add Workout"** button
3. Fill in the workout details in the dialog:
   - Select workout type from the dropdown
   - Enter duration in minutes
   - Enter calories burned
   - Enter distance covered in kilometers
   - Add optional notes
4. Click **"Save"** to log the workout

### Setting a Goal
1. Go to the **Goals** tab
2. Click **"Add Goal"**
3. Enter the goal details:
   - Goal name (e.g., "Run 100km this month")
   - Target value
   - Current value
4. Click **"Save"** to create the goal

### Updating Progress
1. Select a goal from the Goals table
2. Click **"Update Progress"**
3. Enter the new current value
4. The progress percentage and status will update automatically

### Viewing Statistics
- Visit the **Dashboard** tab to see real-time statistics
- Click **"Refresh Stats"** to update the dashboard with latest data

### Deleting Records
- Select a workout or goal from the respective table
- Click the **"Delete"** button
- Confirm the deletion

## 🛠️ Technologies Used

- **Language**: Java (JDK 8+)
- **GUI Framework**: Java Swing
- **Layout Managers**: BorderLayout, GridLayout, FlowLayout
- **Components**: JFrame, JPanel, JTable, JTabbedPane, JDialog
- **Data Structures**: ArrayList for data management
- **Date Handling**: java.util.Date, SimpleDateFormat

## 📂 Project Structure

```
fitness-tracker-app/
│
├── FitnessTrackerApp.java    # Main application class
├── README.md                  # Project documentation
├── LICENSE                    # License file
└── screenshots/               # Application screenshots (optional)
```

## 🔮 Future Enhancements

- [ ] Data persistence (save to file/database)
- [ ] Export data to CSV/PDF
- [ ] Graphical charts for progress visualization
- [ ] Weekly and monthly reports
- [ ] BMI calculator integration
- [ ] Multi-user support with login system
- [ ] Dark mode theme
- [ ] Import data from fitness devices
- [ ] Reminder notifications for workout schedules

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Make your changes
4. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
5. Push to the branch (`git push origin feature/AmazingFeature`)
6. Open a Pull Request

Please ensure your code follows Java coding conventions and includes appropriate comments.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

- GitHub: [@itsomg134](https://github.com/itsomg134)
- Twitter: [@omgedam](https://x.com/its_om_g_143?t=8I7F1GBJO6jLU1AaoQLgYQ&s=09)
- Email: omgedam123098@gmail.com
- Portfolio: [ogworks.lovable.app](https://ogworks.lovable.app)  
- LinkedIn: [Om Gedam](https://www.linkedin.com/in/om-gedam-39686432a)

## 🙏 Acknowledgments

- Java Swing documentation and community
- Inspiration from various fitness tracking applications
- Open-source contributors


⭐ Star this repository if you find it helpful!
