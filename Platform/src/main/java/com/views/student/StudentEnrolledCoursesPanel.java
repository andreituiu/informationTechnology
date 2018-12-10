package com.views.student;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.StudentAssignment;

public class StudentEnrolledCoursesPanel extends JPanel {

    private JTextField textField;

    private JTextField txtDeadline;
    private JTextField textField_1;
    private JTextField textField_2;

    private JLabel deadlineLabel;
    private JLabel lastUploadLabel;
    private JLabel gradeLabel;

    private JButton btnUpload;
    private JButton btnSearch;


    private JTextField deadlineTextField;
    private JTextField lastUploadTextField;
    private JTextField gradeTextField;
    private JComboBox<Assignment> assignmentComboBox;
    private DefaultListModel<Course> coursesListModel;
    private JList<Course> coursesList;
    protected IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;

    public StudentEnrolledCoursesPanel(
            IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController) {
        super();
        this.studentEnrolledCoursesPanelController = studentEnrolledCoursesPanelController;

        initialzie();
    }

    private void initialzie() {
        setLayout(null);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(10, 12, 317, 20);
        add(textField);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(360, 11, 80, 23);
        add(btnSearch);

        JScrollPane courses = new JScrollPane();
        courses.setLocation(10, 43);
        courses.setSize(151, 243);

        coursesListModel = new DefaultListModel<Course>();
        coursesList = new JList<Course>(coursesListModel);

        coursesList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    studentEnrolledCoursesPanelController.courseSelected((Course) coursesList
                            .getSelectedValue());
                }
            }
        });

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
        boxPanel.add(coursesList);
        courses.setViewportView(boxPanel);

        add(courses);

        assignmentComboBox = new JComboBox<Assignment>();
        assignmentComboBox.setBounds(171, 43, 269, 23);
        add(assignmentComboBox);

        assignmentComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                studentEnrolledCoursesPanelController.assignmentSelected(
                        (Assignment) assignmentComboBox.getSelectedItem());

            }
        });
        deadlineTextField = new JTextField();
        deadlineTextField.setBounds(320, 92, 120, 23);
        add(deadlineTextField);
        deadlineTextField.setColumns(10);

        lastUploadTextField = new JTextField();
        lastUploadTextField.setColumns(10);
        lastUploadTextField.setBounds(320, 127, 120, 23);
        add(lastUploadTextField);

        gradeTextField = new JTextField();
        gradeTextField.setColumns(10);
        gradeTextField.setBounds(320, 166, 120, 23);
        add(gradeTextField);

        deadlineLabel = new JLabel("Deadline");
        deadlineLabel.setLocation(192, 92);
        deadlineLabel.setSize(100, 23);
        add(deadlineLabel);

        btnUpload = new JButton("Upload");
        btnUpload.setBounds(269, 204, 89, 23);
        add(btnUpload);

        lastUploadLabel = new JLabel("Last upload");
        lastUploadLabel.setBounds(192, 131, 100, 23);
        add(lastUploadLabel);

        gradeLabel = new JLabel("Grade");
        gradeLabel.setBounds(192, 170, 100, 23);
        add(gradeLabel);
    }

    public void setLanguageBundle(ResourceBundle languageBundle) {

        deadlineLabel.setText(languageBundle.getString("deadline"));
        btnUpload.setText(languageBundle.getString("upload"));
        lastUploadLabel.setText(languageBundle.getString("lastUpload"));
        gradeLabel.setText(languageBundle.getString("grade"));
        btnSearch.setText(languageBundle.getString("search"));

    }

    public void populateCourses(List<Course> courses) {
        ereaseAll();
        if (courses == null || courses.isEmpty()) {
            return;
        }
        for (Course course : courses) {
            coursesListModel.addElement(course);
        }
        coursesList.setSelectedIndex(0);
        studentEnrolledCoursesPanelController.courseSelected(coursesList.getSelectedValue());
    }

    private void ereaseAll() {
        coursesListModel.clear();
        assignmentComboBox.removeAll();
        deadlineTextField.setText("");
        lastUploadTextField.setText("");
        gradeTextField.setText("");
    }

    public void populateAssignments(List<Assignment> courseAssignments) {
        DefaultComboBoxModel<Assignment> model = (DefaultComboBoxModel) assignmentComboBox.getModel();
        model.removeAllElements();
        deadlineTextField.setText("");
        lastUploadTextField.setText("");
        gradeTextField.setText("");
        if (courseAssignments == null || courseAssignments.isEmpty()) {
            return;
        }
        for (Assignment assignment : courseAssignments) {
            assignmentComboBox.addItem(assignment);
        }
        studentEnrolledCoursesPanelController.assignmentSelected((Assignment) assignmentComboBox
                .getSelectedItem());
    }

    public void setDeadline(Date deadline) {
        if (deadline == null) {
            deadlineTextField.setText("");
        } else {
            deadlineTextField.setText(deadline.toString());
        }
    }

    public void setLastUpload(Date lastUpload) {
        if (lastUpload == null) {
            lastUploadTextField.setText("");
        } else {
            lastUploadTextField.setText(lastUpload.toString());
        }
    }

    public void setGrade(Double grade) {
        if (grade == null) {
            gradeTextField.setText("");
        } else {
            gradeTextField.setText(grade.toString());
        }
    }

}