import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner input = new Scanner(System.in);
        CvOwner cvOwner = new CvOwner();
        CvOwnerDaoImpl dbHelper = new CvOwnerDaoImpl();
        dbHelper.deleteAll();
        dbHelper.deleteAll();
        File cv;

        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            cv = fileChooser.getSelectedFile();
            FileUtils.copyToDirectory(cv, new File("cvStorage"));
            cvOwner.setCvFilePath("cvStorage\\" + cv.getName());
//            System.out.println("Save as file: " + x.getPath());
        }

        System.out.print("Enter name: ");
        cvOwner.setName(input.nextLine());
        System.out.print("Enter Surname: ");
        cvOwner.setSurname(input.nextLine());
        System.out.print("Enter department: ");
        cvOwner.setDepartment(input.nextLine());

        dbHelper.add(cvOwner);
        cvOwner.setId(dbHelper.getMaxId());

        System.out.println(cvOwner.getId());
        System.out.println(cvOwner.getName());
        System.out.println(cvOwner.getSurname());
        System.out.println(cvOwner.getDepartment());
        System.out.println(cvOwner.getCvFilePath());


        Desktop.getDesktop().open(new File(cvOwner.getCvFilePath()));


    }
}
