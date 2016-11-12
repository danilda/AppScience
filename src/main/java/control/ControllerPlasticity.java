package control;
import model.*;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.poi.hssf.record.formula.functions.Cell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.Iterator;

/**
 * Created by User on 09.09.2016.
 */
public class ControllerPlasticity {
    private static final String LAST_NAME_COLUMN_HEADER = "Cs";
    private static final String FIRST_NAME_COLUMN_HEADER = "Cf";
    private static final String SECOND_NAME_COLUMN_HEADER = "E*/Em";
    @FXML
    private TextField step;
    @FXML
    private TextField way;
    @FXML
    private TextField fileName;
    @FXML
    private TextField em;
    @FXML
    private TextField es;
    @FXML
    private TextField ef;
    @FXML
    private TextField d;
    @FXML
    private TextField l;

    private PlasticityAndWear plasticityAndWear;

    public void goBuild() throws Exception {
        if(!ef.getText().equals("") && !em.getText().equals("") && !es.getText().equals("")
                && !d.getText().equals("") && !l.getText().equals("") && !way.getText().equals("")
                && !step.getText().equals("") && !fileName.getText().equals("")){
            Matrix matrix = new Matrix();
            DisperseInclusion disperse = new DisperseInclusion();
            Fibers fibers = new Fibers();
            try{
                matrix.setE(Double.parseDouble(em.getText()));
                disperse.setE(Double.parseDouble(es.getText()));
                fibers.setE(Double.parseDouble(ef.getText()));
                fibers.setD(Double.parseDouble(d.getText()));
                fibers.setL(Double.parseDouble(l.getText()));
            } catch (RuntimeException e){
                return;
            }

            plasticityAndWear = new PlasticityAndWear(matrix, disperse, fibers);

            try {
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("Пластичность и износостойкость");
                OutputStream out = new FileOutputStream(way.getText() + fileName.getText() + ".xls");
                System.out.println(way.getText() + fileName.getText() + ".xlsx");
                HSSFRow row;
                HSSFCell cell;

                row = sheet.createRow(0);
                cell = row.createCell((short) 0);
                cell.setCellValue(LAST_NAME_COLUMN_HEADER);
                cell = row.createCell((short) 1);
                cell.setCellValue(FIRST_NAME_COLUMN_HEADER);
                cell = row.createCell((short) 2);
                cell.setCellValue(SECOND_NAME_COLUMN_HEADER);

                double stepIter = Double.parseDouble(step.getText());
                int rowIndex = 1;
                for (double i = stepIter; i <= 0.2; i += stepIter) {
                    for (double y = stepIter; y <= 0.2; y += stepIter) {
                        row = sheet.createRow(rowIndex);
                        cell = row.createCell((short) 0);
                        cell.setCellValue(i);
                        cell = row.createCell((short) 1);
                        cell.setCellValue(y);
                        cell = row.createCell((short) 2);
                        cell.setCellValue(plasticityAndWear.t(i, y));
                        System.out.println(plasticityAndWear.t(i, y));
                        rowIndex++;
                    }
                }
                wb.write(out);
                out.close();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
