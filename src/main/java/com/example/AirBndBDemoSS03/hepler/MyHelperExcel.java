package com.example.AirBndBDemoSS03.hepler;

import com.example.AirBndBDemoSS03.entity.Property;
import com.example.AirBndBDemoSS03.entity.Room;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHelperExcel {
    public static boolean checkExcelFormat(MultipartFile file){
//checking format for excel-check file extension
        String contentType = file.getContentType();
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    //converting excel to list format
    public static List<Room>convertExcelToListOfRoom(InputStream is){
        List<Room>list=new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");

            int rowNo=0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()){
                Row row = iterator.next();

                if(rowNo==0){
                    rowNo++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                Room r=new Room();
                while (cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid){
                        case 0:
                            r.setId((long)cell.getNumericCellValue() );
                            break;
                        case 1:
                            r.setCount((int) cell.getNumericCellValue());
                            break;
                        case 2:

                            r.setDate(cell.getLocalDateTimeCellValue().toLocalDate());
                            break;
                        case 3:
                            r.setPrice((double) cell.getNumericCellValue());
                            break;
                            case 4:
                                r.setRoomType(cell.getStringCellValue());

                                break;
                        case 5:
                            Property property = new Property();
                            property.setId((long) cell.getNumericCellValue());
                            r.setProperty(property);
                            break;

                        default:
                            break;
                    }
                    cid++;
                }
                list.add(r);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
