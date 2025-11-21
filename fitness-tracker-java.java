import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class FitnessTrackerApp extends JFrame {
    private JTabbedPane tabbedPane;
    private DefaultTableModel workoutTableModel;
    private DefaultTableModel goalTableModel;
    private JTable workoutTable;
    private JTable goalTable;
    private List<Workout> workouts;
    private List<Goal> goals;
    
    // Dashboard components
    private JLabel totalWorkoutsLabel;
    private JLabel totalCaloriesLabel;
    private JLabel totalDistanceLabel;
    private JLabel totalDurationLabel;
    
    public FitnessTrackerApp() {
        workouts = new ArrayList<>();
        goals = new ArrayList<>();
        
        setTitle("Fitness Tracker App");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        tabbedPane = new JTabbedPane();
        
        // Create tabs
        JPanel dashboardPanel = createDashboardPanel();
        JPanel workoutPanel = createWorkoutPanel();
        JPanel goalPanel = createGoalPanel();
        
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Workouts", workoutPanel);
        tabbedPane.addTab("Goals", goalPanel);
        
        add(tabbedPane);
    }
    
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Title
        JLabel titleLabel = new JLabel("Fitness Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Stats panel
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        
        JPanel workoutsCard = createStatsCard("Total Workouts", "0", new Color(52, 152, 219));
        JPanel caloriesCard = createStatsCard("Calories Burned", "0 kcal", new Color(46, 204, 113));
        JPanel distanceCard = createStatsCard("Total Distance", "0 km", new Color(155, 89, 182));
        JPanel durationCard = createStatsCard("Total Duration", "0 min", new Color(241, 196, 15));
        
        totalWorkoutsLabel = (JLabel) workoutsCard.getComponent(1);
        totalCaloriesLabel = (JLabel) caloriesCard.getComponent(1);
        totalDistanceLabel = (JLabel) distanceCard.getComponent(1);
        totalDurationLabel = (JLabel) durationCard.getComponent(1);
        
        statsPanel.add(workoutsCard);
        statsPanel.add(caloriesCard);
        statsPanel.add(distanceCard);
        statsPanel.add(durationCard);
        
        panel.add(statsPanel, BorderLayout.CENTER);
        
        // Recent activity
        JPanel recentPanel = new JPanel(new BorderLayout());
        recentPanel.setBorder(BorderFactory.createTitledBorder("Quick Actions"));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addWorkoutBtn = new JButton("Add Workout");
        JButton addGoalBtn = new JButton("Add Goal");
        JButton refreshBtn = new JButton("Refresh Stats");
        
        addWorkoutBtn.addActionListener(e -> {
            tabbedPane.setSelectedIndex(1);
        });
        
        addGoalBtn.addActionListener(e -> {
            tabbedPane.setSelectedIndex(2);
        });
        
        refreshBtn.addActionListener(e -> updateDashboard());
        
        buttonPanel.add(addWorkoutBtn);
        buttonPanel.add(addGoalBtn);
        buttonPanel.add(refreshBtn);
        
        recentPanel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(recentPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createStatsCard(String title, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBackground(color);
        card.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));
        valueLabel.setForeground(Color.WHITE);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createWorkoutPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title
        JLabel titleLabel = new JLabel("Workout Log");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Table
        String[] columns = {"Date", "Type", "Duration (min)", "Calories", "Distance (km)", "Notes"};
        workoutTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        workoutTable = new JTable(workoutTableModel);
        JScrollPane scrollPane = new JScrollPane(workoutTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addBtn = new JButton("Add Workout");
        JButton deleteBtn = new JButton("Delete Workout");
        
        addBtn.addActionListener(e -> showAddWorkoutDialog());
        deleteBtn.addActionListener(e -> deleteSelectedWorkout());
        
        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createGoalPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title
        JLabel titleLabel = new JLabel("Fitness Goals");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Table
        String[] columns = {"Goal", "Target", "Current", "Progress %", "Status"};
        goalTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        goalTable = new JTable(goalTableModel);
        JScrollPane scrollPane = new JScrollPane(goalTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addBtn = new JButton("Add Goal");
        JButton deleteBtn = new JButton("Delete Goal");
        JButton updateBtn = new JButton("Update Progress");
        
        addBtn.addActionListener(e -> showAddGoalDialog());
        deleteBtn.addActionListener(e -> deleteSelectedGoal());
        updateBtn.addActionListener(e -> showUpdateProgressDialog());
        
        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(updateBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void showAddWorkoutDialog() {
        JDialog dialog = new JDialog(this, "Add Workout", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel typeLabel = new JLabel("Workout Type:");
        String[] types = {"Running", "Cycling", "Swimming", "Gym", "Yoga", "Walking", "Other"};
        JComboBox<String> typeCombo = new JComboBox<>(types);
        
        JLabel durationLabel = new JLabel("Duration (min):");
        JTextField durationField = new JTextField();
        
        JLabel caloriesLabel = new JLabel("Calories Burned:");
        JTextField caloriesField = new JTextField();
        
        JLabel distanceLabel = new JLabel("Distance (km):");
        JTextField distanceField = new JTextField();
        
        JLabel notesLabel = new JLabel("Notes:");
        JTextField notesField = new JTextField();
        
        panel.add(typeLabel);
        panel.add(typeCombo);
        panel.add(durationLabel);
        panel.add(durationField);
        panel.add(caloriesLabel);
        panel.add(caloriesField);
        panel.add(distanceLabel);
        panel.add(distanceField);
        panel.add(notesLabel);
        panel.add(notesField);
        
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        saveBtn.addActionListener(e -> {
            try {
                String type = (String) typeCombo.getSelectedItem();
                int duration = Integer.parseInt(durationField.getText());
                int calories = Integer.parseInt(caloriesField.getText());
                double distance = Double.parseDouble(distanceField.getText());
                String notes = notesField.getText();
                
                Workout workout = new Workout(new Date(), type, duration, calories, distance, notes);
                workouts.add(workout);
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                workoutTableModel.addRow(new Object[]{
                    sdf.format(workout.date),
                    workout.type,
                    workout.duration,
                    workout.calories,
                    workout.distance,
                    workout.notes
                });
                
                updateDashboard();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Workout added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        panel.add(saveBtn);
        panel.add(cancelBtn);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showAddGoalDialog() {
        JDialog dialog = new JDialog(this, "Add Goal", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel goalLabel = new JLabel("Goal Name:");
        JTextField goalField = new JTextField();
        
        JLabel targetLabel = new JLabel("Target Value:");
        JTextField targetField = new JTextField();
        
        JLabel currentLabel = new JLabel("Current Value:");
        JTextField currentField = new JTextField();
        
        panel.add(goalLabel);
        panel.add(goalField);
        panel.add(targetLabel);
        panel.add(targetField);
        panel.add(currentLabel);
        panel.add(currentField);
        
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        saveBtn.addActionListener(e -> {
            try {
                String goalName = goalField.getText();
                double target = Double.parseDouble(targetField.getText());
                double current = Double.parseDouble(currentField.getText());
                
                Goal goal = new Goal(goalName, target, current);
                goals.add(goal);
                
                double progress = (current / target) * 100;
                String status = progress >= 100 ? "Completed" : "In Progress";
                
                goalTableModel.addRow(new Object[]{
                    goal.name,
                    String.format("%.1f", goal.target),
                    String.format("%.1f", goal.current),
                    String.format("%.1f%%", progress),
                    status
                });
                
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Goal added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        panel.add(saveBtn);
        panel.add(cancelBtn);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showUpdateProgressDialog() {
        int selectedRow = goalTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a goal to update!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Goal goal = goals.get(selectedRow);
        
        String input = JOptionPane.showInputDialog(this, "Enter new current value:", goal.current);
        if (input != null && !input.isEmpty()) {
            try {
                double newCurrent = Double.parseDouble(input);
                goal.current = newCurrent;
                
                double progress = (newCurrent / goal.target) * 100;
                String status = progress >= 100 ? "Completed" : "In Progress";
                
                goalTableModel.setValueAt(String.format("%.1f", newCurrent), selectedRow, 2);
                goalTableModel.setValueAt(String.format("%.1f%%", progress), selectedRow, 3);
                goalTableModel.setValueAt(status, selectedRow, 4);
                
                JOptionPane.showMessageDialog(this, "Progress updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void deleteSelectedWorkout() {
        int selectedRow = workoutTable.getSelectedRow();
        if (selectedRow != -1) {
            workouts.remove(selectedRow);
            workoutTableModel.removeRow(selectedRow);
            updateDashboard();
            JOptionPane.showMessageDialog(this, "Workout deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a workout to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void deleteSelectedGoal() {
        int selectedRow = goalTable.getSelectedRow();
        if (selectedRow != -1) {
            goals.remove(selectedRow);
            goalTableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Goal deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a goal to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void updateDashboard() {
        int totalWorkouts = workouts.size();
        int totalCalories = workouts.stream().mapToInt(w -> w.calories).sum();
        double totalDistance = workouts.stream().mapToDouble(w -> w.distance).sum();
        int totalDuration = workouts.stream().mapToInt(w -> w.duration).sum();
        
        totalWorkoutsLabel.setText(String.valueOf(totalWorkouts));
        totalCaloriesLabel.setText(totalCalories + " kcal");
        totalDistanceLabel.setText(String.format("%.1f km", totalDistance));
        totalDurationLabel.setText(totalDuration + " min");
    }
    
    // Inner classes
    class Workout {
        Date date;
        String type;
        int duration;
        int calories;
        double distance;
        String notes;
        
        Workout(Date date, String type, int duration, int calories, double distance, String notes) {
            this.date = date;
            this.type = type;
            this.duration = duration;
            this.calories = calories;
            this.distance = distance;
            this.notes = notes;
        }
    }
    
    class Goal {
        String name;
        double target;
        double current;
        
        Goal(String name, double target, double current) {
            this.name = name;
            this.target = target;
            this.current = current;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new FitnessTrackerApp();
        });
    }
}