package com.example.demo1;

import com.example.demo1.BLL.*;
import com.example.demo1.DAL.*;
import com.example.demo1.models.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.List;

public class HelloController {

    //all
    StudentGradeDAL studentGradeDAL = new StudentGradeDAL();
    PersonDAL personDAL = new PersonDAL();
    CourseDAL courseDAL = new CourseDAL();
    CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();
    OnlineCourseDAL onlineCourseDAL = new OnlineCourseDAL();
    StudentGradeBLL studentGradeBLL = new StudentGradeBLL();
    PersonBLL personBLL = new PersonBLL();
    OnsiteCourseBLL onsiteCourseBLL = new OnsiteCourseBLL();
    OnlineCourseBLL onlineCourseBLL = new OnlineCourseBLL();
    CourseIntructorBLL courseIntructorBLL = new CourseIntructorBLL();

    //data
    boolean displayOSite = false;
    boolean displayPerson = false;
    boolean displayOLine = false;
    boolean displayIntructor = false;
    boolean displaySG = false;
    List<SGConvert> sgConverts;
    List<Person> peoples;
    List<Course> courses;
    List<CIConvert> ciConverts;
    List<OnsiteCourse> onsiteCourses;
    List<OnlineCourse> onlineCourses;
    List<Person> persons;

    //

    @FXML
    private Label welcomeText,idLBNotification;

    @FXML
    private Button idBtnPerson, idBtnGoodbye, idBtnOnlineCourse, idBtnOnsiteCourse, idBtnCourseIntructor, idBtnStudentGrade;

    @FXML
    private Pane idPanePerson, idPaneGoodbye, idPaneOnsite, idPaneIntructor, idPaneGrade;

    @FXML
    private ListView<String> idLVStudentGrade;

    //Person table
    @FXML
    private TableView<Person> idTablePerson;
    @FXML
    private TableColumn<Person, Integer> idTCPerson;
    @FXML
    private TableColumn<Person, String> idTCLastName;
    @FXML
    private TableColumn<Person, String> idTCFirstName;
    @FXML
    private TableColumn<Person, String> idTCHireDate;
    @FXML
    private TableColumn<Person, String> idEnrollmentDate;

    //student grade
    @FXML
    private ComboBox<String> idCBNameSGM, idCBTitleSGM;
    @FXML
    private Button idBtnInsertSGM, idBtnUpdateSGM, idBtnDeleteSGM;
    @FXML
    private TextField idTFGradeSGM;

    //course intructor
    @FXML
    private ComboBox<String> idCBCourseCI, idCBNameCI;
    @FXML
    private ListView<String> idLVCourseIntructorCI;
    @FXML
    private Button idBtnInsertCI, idBtnUpdateCI, idBtnDeleteCI;

    //onsite
    @FXML
    private ComboBox<String> idCBCourseOSite;
    @FXML
    private TextField idTFLocationOSite;
    @FXML
    private ListView<String> idLVOSite;
    @FXML
    private Button idBtnInsertOSite, idBtnUpdateOSite, idBtnDeleteOSite;
    @FXML
    private TextField idTFDayOSite, idTFTimeOSite, idTFSearchLocation, idTFSearchDay;
    //online
    @FXML
    private ComboBox<String> idCBCourseIDOLine;
    @FXML
    private TextField idTFURLOLine;
    @FXML
    private ListView<String> idLVOLine;
    @FXML
    private Button idBtnInsetOLine, idBtnUpdateOLine, idBtnDeleteOLine;

    //person
    @FXML
    private TextField idTFIDPerson, idTFHireDatePerson, idTFFNamePerson, idTFLNamePerson, idTFDayPerson, idTFFindPerson;
    @FXML
    private ListView<String> idLVPerson;

    @FXML
    protected void handleButtonAction(ActionEvent event) {
        if (event.getSource() == idBtnPerson) {
            idPanePerson.toFront();
            welcomeText.setText("Person Management");
            if (!displayPerson) {
                displayPerson();
                displayPerson = !displayPerson;
            }
        } else if (event.getSource() == idBtnGoodbye) {
            idPaneGoodbye.toFront();
            welcomeText.setText("goodbye");
            if (!displayOLine) {
                displayOnline();
                displayOLine = !displayOLine;
            }

        } else if (event.getSource() == idBtnOnsiteCourse) {
            idPaneOnsite.toFront();
            welcomeText.setText("Onsite Course Management");
            if (!displayOSite) {
                displayOSite();
                displayOSite = !displayOSite;
            }

        } else if (event.getSource() == idBtnCourseIntructor) {
            idPaneIntructor.toFront();
            welcomeText.setText("Course Intructor Management");
            if (!displayIntructor) {
                displayCI();
                displayIntructor = !displayIntructor;
            }

        } else if (event.getSource() == idBtnStudentGrade) {
            idPaneGrade.toFront();
            welcomeText.setText("Student Grade Management");
            if (!displaySG) {
                displaySG();
                displaySG = !displaySG;
            }
        }
    }

    //student grade
    public void displaySG() {
//        idLVStudentGrade.getItems().clear();
        sgConverts = studentGradeDAL.getStudentGrade();
        peoples = personDAL.getPersons();
        courses = courseDAL.getCourses();
        for (SGConvert s : sgConverts) {
            idLVStudentGrade.getItems().add(s.getPerson().getFirstName() + "---" + s.getCourse().getTitle() + "---" + s.getGrade());
//            idCBNameSGM.getItems().add(s.getPerson().getFirstName()+" "+s.getPerson().getLastName());
//            idCBTitleSGM.getItems().add(s.getCourse().getTitle());
        }
        for (Person p : peoples) {
            idCBNameSGM.getItems().add(p.getFirstName() + " " + p.getLastName());
        }
        for (Course c : courses) {
            idCBTitleSGM.getItems().add(c.getTitle());
        }
        showLVSGM();
//        idLVStudentGrade.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                System.out.println(sgConverts.get((Integer) t1).getPerson().getFirstName());
//                idCBNameSGM.getSelectionModel().select(sgConverts.get((Integer) t1).getPerson().getFirstName()+" "+sgConverts.get((Integer) t1).getPerson().getLastName());
//                idCBTitleSGM.getSelectionModel().select(sgConverts.get((Integer) t1).getCourse().getTitle());
//            }
//        });
    }

    @FXML
    protected void handleInsertSGM(ActionEvent event) {
        StudentGrade studentGrade = new StudentGrade(null, courses.get(idCBTitleSGM.getSelectionModel().getSelectedIndex()).getCourseID(), peoples.get(idCBNameSGM.getSelectionModel().getSelectedIndex()).getPersonID(), idTFGradeSGM.getText());
//        studentGradeDAL.insertStudentGrade(studentGrade);
        if(studentGradeBLL.checkInsert(studentGrade)){
            idLBNotification.setText("insert student grade success");
        }else {
            idLBNotification.setText("insert fail");
        }
        idCBTitleSGM.getSelectionModel().select("");
        idCBNameSGM.getSelectionModel().select("");
        idTFGradeSGM.setText("");
    }

    @FXML
    protected void handleUpdateSGM(ActionEvent event) {
        int id = sgConverts.get(idLVStudentGrade.getSelectionModel().getSelectedIndex()).getEnrollmentID();
        StudentGrade newSG = new StudentGrade(id, courses.get(idCBTitleSGM.getSelectionModel().getSelectedIndex()).getCourseID(), peoples.get(idCBNameSGM.getSelectionModel().getSelectedIndex()).getPersonID(), idTFGradeSGM.getText());
//        studentGradeDAL.updateStudentGrade(newSG);
        if(studentGradeBLL.checkUpdate(newSG)){
            idLBNotification.setText("update student grade success");
        }else {
            idLBNotification.setText("update fail");
        }
        idCBTitleSGM.getSelectionModel().select("");
        idCBNameSGM.getSelectionModel().select("");
        idTFGradeSGM.setText("");
    }

    @FXML
    protected void handleDeleteSGM(ActionEvent event) {
        int id = sgConverts.get(idLVStudentGrade.getSelectionModel().getSelectedIndex()).getEnrollmentID();
        studentGradeDAL.deleteStudentGrade(id);
        if(studentGradeBLL.checkDelete(id)){
            idLBNotification.setText("Delete student grade success");
        }else {
            idLBNotification.setText("Delete student grade fail");
        }
        idCBTitleSGM.getSelectionModel().select("");
        idCBNameSGM.getSelectionModel().select("");
        idTFGradeSGM.setText("");
    }

    public void showLVSGM() {
        idLVStudentGrade.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                System.out.println(sgConverts.get((Integer) t1).getPerson().getFirstName());
                idCBNameSGM.getSelectionModel().select(sgConverts.get((Integer) t1).getPerson().getFirstName() + " " + sgConverts.get((Integer) t1).getPerson().getLastName());
                idCBTitleSGM.getSelectionModel().select(sgConverts.get((Integer) t1).getCourse().getTitle());
                idTFGradeSGM.setText(sgConverts.get((Integer) t1).getGrade());
            }
        });
    }

    //course intructor
    public void displayCI() {
        ciConverts = courseInstructorDAL.getCourseInstructor();
        for (CIConvert c : ciConverts) {
            idLVCourseIntructorCI.getItems().add(c.getCourse().getTitle() + "---" + c.getPerson().getLastName());
        }
        peoples = personDAL.getPersons();
        courses = courseDAL.getCourses();
        for (Person p : peoples) {
            idCBNameCI.getItems().add(p.getFirstName() + " " + p.getLastName());
        }
        for (Course c : courses) {
            idCBCourseCI.getItems().add(c.getTitle());
        }
        idLVCourseIntructorCI.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                idCBNameCI.getSelectionModel().select(ciConverts.get((Integer) t1).getPerson().getFirstName() + " " + ciConverts.get((Integer) t1).getPerson().getLastName());
                idCBCourseCI.getSelectionModel().select(ciConverts.get((Integer) t1).getCourse().getTitle());
            }
        });
    }

    @FXML
    protected void handleInsertCI(ActionEvent event) {
        int courseID = courses.get(idCBCourseCI.getSelectionModel().getSelectedIndex()).getCourseID();
        int personID = peoples.get(idCBNameCI.getSelectionModel().getSelectedIndex()).getPersonID();
        CourseInstructor courseInstructor = new CourseInstructor(courseID,personID);
        if(courseIntructorBLL.checkInsert(courseInstructor)){
            idLBNotification.setText("Insert Course Instructor success");
        }
        else {
            idLBNotification.setText("Insert Course Instructor fail");
        }
    }

    @FXML
    protected void handleUpdateCI(ActionEvent event) {
        int oldCourseID = ciConverts.get(idLVCourseIntructorCI.getSelectionModel().getSelectedIndex()).getCourse().getCourseID();
        int oldPersonID = ciConverts.get(idLVCourseIntructorCI.getSelectionModel().getSelectedIndex()).getPerson().getPersonID();
        int newCourseID = courses.get(idCBCourseCI.getSelectionModel().getSelectedIndex()).getCourseID();
        int newPersonID = peoples.get(idCBNameCI.getSelectionModel().getSelectedIndex()).getPersonID();
        CourseInstructor oldCourseInstructor = new CourseInstructor(oldCourseID, oldPersonID);
        CourseInstructor newCourseInstructor = new CourseInstructor(newCourseID, newPersonID);
        if(courseIntructorBLL.checkUpdate(oldCourseInstructor, newCourseInstructor)){
            idLBNotification.setText("Update Course Instructor success");
        }
        else {
            idLBNotification.setText("Update Course Instructor fail");
        }
    }

    @FXML
    protected void handleDeleteCI(ActionEvent event) {
        int oldCourseID = ciConverts.get(idLVCourseIntructorCI.getSelectionModel().getSelectedIndex()).getCourse().getCourseID();
        int oldPersonID = ciConverts.get(idLVCourseIntructorCI.getSelectionModel().getSelectedIndex()).getPerson().getPersonID();
        CourseInstructor oldCourseInstructor = new CourseInstructor(oldCourseID, oldPersonID);
        if(courseIntructorBLL.checkDelete(oldCourseInstructor)){
            idLBNotification.setText("Delete Course Instructor success");
        }
        else {
            idLBNotification.setText("Delete Course Instructor fail");
        }
    }

    //onsite course
    public void displayOSite() {

        onsiteCourses = onsiteCourseDAL.getOnsiteCourse();
        List<Course> courses = courseDAL.getCourses();
        for (Course c : courses) {
            idCBCourseOSite.getItems().add(c.getCourseID().toString());
        }
        for (OnsiteCourse onsiteCourse : onsiteCourses) {
            idLVOSite.getItems().add(onsiteCourse.getCourseID() + "----" + onsiteCourse.getLocation() + "---" + onsiteCourse.getDays());
        }
        idLVOSite.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                idCBCourseOSite.getSelectionModel().select(onsiteCourses.get((Integer) t1).getCourseID().toString());
                idTFLocationOSite.setText(onsiteCourses.get((Integer) t1).getLocation());
                idTFDayOSite.setText(onsiteCourses.get((Integer) t1).getDays());
                idTFTimeOSite.setText(onsiteCourses.get((Integer) t1).getTime());
            }
        });
    }

    @FXML
    protected void handleInsertOSite(ActionEvent event) {
        int id = Integer.parseInt(idCBCourseOSite.getSelectionModel().getSelectedItem());
        String location = idTFLocationOSite.getText();
        String day = idTFDayOSite.getText();
        String time = idTFTimeOSite.getText();
        OnsiteCourse onsiteCourse = new OnsiteCourse(id, location, day, time);
        if(onsiteCourseBLL.checkInsert(onsiteCourse)){
            idLBNotification.setText("Insert Onsite Course success");
        }
        else {
            idLBNotification.setText("Insert Onsite Course fail");
        }

//        onsiteCourseDAL.insertOnsiteCourse(onsiteCourse);
    }

    @FXML
    protected void handleUpdateOSite(ActionEvent event) {
        int id = Integer.parseInt(idCBCourseOSite.getSelectionModel().getSelectedItem());
        String location = idTFLocationOSite.getText();
        String day = idTFDayOSite.getText();
        String time = idTFTimeOSite.getText();
        OnsiteCourse onsiteCourse = new OnsiteCourse(id, location, day, time);
        if(onsiteCourseBLL.checkUpdate(onsiteCourse)){
            idLBNotification.setText("Update Onsite Course success");
        }
        else {
            idLBNotification.setText("Update Onsite Course fail");
        }
//        onsiteCourseDAL.updateOnsiteCourse(onsiteCourse);
    }

    @FXML
    protected void handleDeleteOSite(ActionEvent event) {
        int id = Integer.parseInt(idCBCourseOSite.getSelectionModel().getSelectedItem());
//        onsiteCourseDAL.deleteOnsiteCourse(id);
        if(onsiteCourseBLL.checkDelete(id)){
            idLBNotification.setText("Delete Onsite Course success");
        }
        else {
            idLBNotification.setText("Delete Onsite Course fail");
        }
    }


    //Online
    public void displayOnline() {
        onlineCourses = onlineCourseDAL.getOnlineCourse();
        for (OnlineCourse o : onlineCourses) {
            idLVOLine.getItems().add(o.getCourseID() + ":" + o.getUrl());
        }
        courses = courseDAL.getCourses();
        for (Course c : courses) {
            idCBCourseIDOLine.getItems().add(c.getCourseID().toString());
        }
        idLVOLine.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                idCBCourseIDOLine.getSelectionModel().select(onlineCourses.get((Integer) t1).getCourseID().toString());
//                System.out.println(onlineCourses.get((Integer) t1).getCourseID());
                idTFURLOLine.setText(onlineCourses.get((Integer) t1).getUrl());
            }
        });

    }

    @FXML
    protected void handleInsertOLite(ActionEvent event) {
        int id = courses.get(idCBCourseIDOLine.getSelectionModel().getSelectedIndex()).getCourseID();
        String url = idTFURLOLine.getText();
        OnlineCourse onlineCourse = new OnlineCourse(id, url);
//        onlineCourseDAL.insertOnlineCourse(onlineCourse);
        System.out.println(id+url);
        if (onlineCourseBLL.checkInsert(onlineCourse)){
            idLBNotification.setText("Insert Online Course success");
        }else {
            idLBNotification.setText("the course already exists");
        }
    }

    @FXML
    protected void handleUpdateOLite(ActionEvent event) {
        int id = courses.get(idCBCourseIDOLine.getSelectionModel().getSelectedIndex()).getCourseID();
        String url = idTFURLOLine.getText();
        OnlineCourse onlineCourse = new OnlineCourse(id, url);
//        onlineCourseDAL.updateOnlineCourse(onlineCourse);
        if (onlineCourseBLL.checkUpdate(onlineCourse)){
            idLBNotification.setText("Update Online Course success");
        }else {
            idLBNotification.setText("Update Online Course fail");
        }
    }

    @FXML
    protected void handleDeleteOLite(ActionEvent event) {
        int id = courses.get(idCBCourseIDOLine.getSelectionModel().getSelectedIndex()).getCourseID();
//        onlineCourseDAL.deleteOnlineCourse(id);
        if (onlineCourseBLL.checkDelete(id)){
            idLBNotification.setText("Delete Online Course success");
        }else {
            idLBNotification.setText("Delete Online Course fail");
        }
    }

    //person
    public void displayPerson() {
        persons = personDAL.getPersons();
        for (Person p : persons) {
            idLVPerson.getItems().add(p.getPersonID() + ":" + p.getFirstName() + " " + p.getLastName());
        }
        idLVPerson.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                idTFIDPerson.setText(persons.get((Integer) t1).getPersonID().toString());
                idTFHireDatePerson.setText(persons.get((Integer) t1).getHireDate());
                idTFFNamePerson.setText(persons.get((Integer) t1).getFirstName());
                idTFLNamePerson.setText(persons.get((Integer) t1).getLastName());
                idTFDayPerson.setText(persons.get((Integer) t1).getEnrollmentDate());
            }
        });
    }

    @FXML
    protected void handleInsertPerson() {

        String fName = idTFFNamePerson.getText();
        String lName = idTFLNamePerson.getText();
        String hireDate = idTFHireDatePerson.getText();
        String eDay = idTFDayPerson.getText();
        if(hireDate.equals("")){
            hireDate = null;
        }
        if ((eDay.equals(""))){
            eDay = null;
        }
        Person person = new Person(null,lName,fName,hireDate,eDay);
        if(personBLL.checkInsert(person)){
            idLBNotification.setText("Insert Person success");
        }else {
            idLBNotification.setText("Insert Person fail");
        }
//        System.out.println(person.getPersonID()+person.getLastName()+person.getFirstName()+person.getHireDate()+person.getEnrollmentDate());
    }

    @FXML
    protected void handleUpdatePerson() {
        Person person = new Person();
        int id = persons.get(idLVPerson.getSelectionModel().getSelectedIndex()).getPersonID();
        String fName = idTFFNamePerson.getText();
        String lName = idTFLNamePerson.getText();
        String hireDay = idTFHireDatePerson.getText();
        String eDay = idTFDayPerson.getText();
        if(hireDay.equals("")){
            hireDay = null;
        }
        if ((eDay.equals(""))){
            eDay = null;
        }
        person.setPersonID(id);
        person.setFirstName(fName);
        person.setLastName(lName);
        person.setHireDate(hireDay);
        person.setEnrollmentDate(eDay);
        System.out.println(id);
        if(personBLL.checkUpdate(person)){
            idLBNotification.setText("Update Person success");
        }else {
            idLBNotification.setText("Update Person fail");
        }
    }

    @FXML
    protected void handleDeletePerson() {
        int id = persons.get(idLVPerson.getSelectionModel().getSelectedIndex()).getPersonID();
        System.out.println(id);
        if(personBLL.checkDelete(id)){
            idLBNotification.setText("Delete Person success");
        }else {
            idLBNotification.setText("Delete Person fail");
        }
    }

    //search
    @FXML
    protected void searchPerson() {
        idLVPerson.getItems().clear();
        persons = personDAL.findPerson(idTFFindPerson.getText());
        for (Person p : persons) {
            idLVPerson.getItems().add(p.getPersonID() + ":" + p.getFirstName() + " " + p.getLastName());
        }
    }

    @FXML
    protected void searchLocation() {
        idLVOSite.getItems().clear();
        onsiteCourses = onsiteCourseDAL.findOnsiteCourseLocation(idTFSearchLocation.getText());
        for (OnsiteCourse onsiteCourse : onsiteCourses) {
            idLVOSite.getItems().add(onsiteCourse.getCourseID() + "----" + onsiteCourse.getLocation() + "---" + onsiteCourse.getDays());
        }
        idTFSearchLocation.setText("");
    }

    @FXML
    protected void searchDay() {
        idLVOSite.getItems().clear();
        onsiteCourses = onsiteCourseDAL.findOnsiteCourseDays(idTFSearchDay.getText());
        for (OnsiteCourse onsiteCourse : onsiteCourses) {
            idLVOSite.getItems().add(onsiteCourse.getCourseID() + "----" + onsiteCourse.getLocation() + "---" + onsiteCourse.getDays());
        }
        idTFSearchDay.setText("");
    }

}