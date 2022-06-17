package com.example.demo.n_model.file_xlsx;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import com.example.demo.n_model.mapping;
import com.example.demo.project_polamakan.repo.rep_anggota;
import com.example.demo.project_polamakan.repo.rep_batch;
import com.example.demo.project_polamakan.repo.rep_legacy_anggota;
import com.example.demo.project_polamakan.table.dftr_anggota;
import com.example.demo.project_polamakan.table.dftr_batch;
import com.example.demo.project_polamakan.table.legacy.legacy_anggota;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.*;

@Getter
@Setter

@Component
public class xlsx {

    private Workbook workbook;
    private Sheet sheet;
    private Row header;
    private Cell headercell;

    private Row row_data;
    private int row_number;
    private CellStyle style;
    private Cell cell_data;

    private String fileLoc;
    @Autowired
    rep_anggota rep_anggota;
    @Autowired
    rep_batch rep_batch;
    @Autowired
    rep_legacy_anggota rep_legacy_anggota;

    public boolean readAnggota(Integer sheetno, FileInputStream file_import) {
        try {

            Workbook workbook = new XSSFWorkbook(file_import);
            Sheet sheet = workbook.getSheetAt(sheetno);
            System.out.println(workbook.getNumberOfSheets());
            // Iterator<Row> iterator = sheet.iterator();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            // Map<Integer, List<String>> data = new HashMap<>();
            mapping map_anggota = new mapping();
            // int i = 0;
            int num_of_row = 1;
            boolean endofline = false;

            for (Row row : sheet) {
                // data.put(i, new ArrayList<String>());

                Integer number = 1;
                dftr_anggota newAnggota = new dftr_anggota();
                @SuppressWarnings("unchecked")
                Map<String, Object> mapped_object = new ObjectMapper().convertValue(newAnggota, Map.class);
                if (num_of_row != 1) {
                    for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                        Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        // // Cell cell = cellIterator.next();
                        // CellReference cellRef = new CellReference(row.getRowNum(),
                        // cell.getColumnIndex());
                        // System.out.print(cellRef.formatAsString());
                        // System.out.print(" - ");
                        // // get the text that appears in the cell by getting the cell value and
                        // applying
                        // // any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                        // String text = formatter.formatCellValue(cell);
                        // System.out.println(text);
                        System.out.print(number + ". ");

                        String s_value = null;
                        // Double n_value = null;
                        Map<Integer, String> wasd = map_anggota.getMapping1();
                        Map<String, String> wasd2 = map_anggota.getMapping2();
                        String key_map = wasd2.get(wasd.get(number));
                        if (number == 33) {
                            System.out.print(" type: " + cell.getCellType() + " ");
                        }
                        switch (cell.getCellType()) {
                            case STRING:
                                endofline = false;

                                System.out.println(cell.getRichStringCellValue().getString());
                                s_value = cell.getRichStringCellValue().getString();

                                if (mapped_object.containsKey(key_map)) {
                                    mapped_object.put(key_map, s_value);
                                }
                                break;
                            case NUMERIC:
                                endofline = false;
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    // data.get(i).add(cell.getDateCellValue() + "");
                                    System.out.println(cell.getDateCellValue() + "");
                                    s_value = cell.getDateCellValue().toString();
                                    if (mapped_object.containsKey(key_map)) {
                                        mapped_object.put(key_map, s_value);
                                    }

                                } else {
                                    // data.get(i).add(cell.getNumericCellValue() + "");
                                    if (number == 4) {
                                        System.out.println(
                                                "0" + new BigDecimal(cell.getNumericCellValue()).toPlainString());
                                        s_value = "0" + new BigDecimal(cell.getNumericCellValue()).toPlainString();
                                        if (mapped_object.containsKey(key_map)) {
                                            mapped_object.put(key_map, s_value);
                                        }
                                    } else {
                                        System.out.println(cell.getNumericCellValue() + "");
                                        s_value = cell.getNumericCellValue() + "";
                                        if (mapped_object.containsKey(key_map)) {
                                            mapped_object.put(key_map, s_value);
                                        }
                                    }

                                }
                                break;
                            case BOOLEAN:
                                System.out.println(cell.getBooleanCellValue() + "");
                                endofline = false;
                                break;
                            case FORMULA:
                                // System.out.println(cell.getCellFormula() + "");
                                endofline = false;

                                switch (evaluator.evaluateFormulaCell(cell)) {
                                    case BOOLEAN:
                                        System.out.println(cell.getBooleanCellValue());
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    case NUMERIC:
                                        System.out.println(cell.getNumericCellValue());
                                        s_value = cell.getNumericCellValue() + "";
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    case STRING:
                                        System.out.println(cell.getStringCellValue());
                                        s_value = cell.getStringCellValue();
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    default:
                                        break;
                                }

                                break;
                            default:
                                System.out.print("kosong " + number);
                                endofline = true;
                                break;
                        }
                        System.out.print("\n");
                        number++;
                    }

                    if (endofline == false) {

                        System.out.println(mapped_object);
                        newAnggota = new ObjectMapper().convertValue(mapped_object, dftr_anggota.class);
                        System.out.println(newAnggota.getNama());
                        if (rep_anggota.existsById(newAnggota.getNoMember())) {
                            System.out.println("lama");
                            dftr_anggota old_anggota = rep_anggota.findById(newAnggota.getNoMember()).get();
                            if (!old_anggota.getJsonencode().equals(mapped_object.toString())) {
                                newAnggota.setVersion(old_anggota.getVersion() + 1);
                                newAnggota.setJsonencode(mapped_object.toString());
                                rep_anggota.save(newAnggota);
                                legacy_anggota rec_anggota = new legacy_anggota();
                                rec_anggota.setJsonencode(newAnggota.getJsonencode());
                                rec_anggota.setVersion(newAnggota.getVersion());
                                rec_anggota.setNoMember(newAnggota.getNoMember());
                                rec_anggota.setCreatedAt(new Date());
                                rep_legacy_anggota.save(rec_anggota);
                            }
                        } else {
                            System.out.println("baru");
                            newAnggota.setJsonencode(mapped_object.toString());
                            rep_anggota.save(newAnggota);
                            legacy_anggota rec_anggota = new legacy_anggota();
                            rec_anggota.setJsonencode(newAnggota.getJsonencode());
                            rec_anggota.setVersion(newAnggota.getVersion());
                            rec_anggota.setNoMember(newAnggota.getNoMember());
                            rec_anggota.setCreatedAt(new Date());
                            rep_legacy_anggota.save(rec_anggota);
                        }

                    } else {
                        break;
                    }

                }

                if (endofline == false) {

                    // i++;
                    num_of_row++;
                    System.out.println("next row");

                }

            }
            workbook.close();
            System.out.println("Sukses");
            System.out.println(num_of_row);
            return true;
        } catch (

        Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readBatch(Integer sheetno, FileInputStream file_import) {
        try {

            Workbook workbook = new XSSFWorkbook(file_import);
            Sheet sheet = workbook.getSheetAt(sheetno);
            System.out.println(workbook.getNumberOfSheets());
            // Iterator<Row> iterator = sheet.iterator();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            Map<Integer, List<String>> data = new HashMap<>();
            mapping map_anggota = new mapping();
            int i = 0;
            int num_of_row = 1;
            boolean endofline = false;

            for (Row row : sheet) {
                data.put(i, new ArrayList<String>());

                Integer number = 1;
                dftr_batch newBatch = new dftr_batch();
                @SuppressWarnings("unchecked")
                Map<String, Object> mapped_object = new ObjectMapper().convertValue(newBatch, Map.class);

                if (num_of_row != 1) {
                    for (int cn = 0; cn < 11; cn++) {
                        Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                        String s_value = null;
                        Double n_value = null;
                        Map<Integer, String> wasd = map_anggota.getMapping3();
                        Map<String, String> wasd2 = map_anggota.getMapping4();
                        String key_map = wasd2.get(wasd.get(number));

                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(number + ". ");
                                endofline = false;
                                data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
                                System.out.println(cell.getRichStringCellValue().getString());
                                s_value = cell.getRichStringCellValue().getString();

                                if (mapped_object.containsKey(key_map)) {
                                    mapped_object.put(key_map, s_value);
                                }
                                break;
                            case NUMERIC:
                                System.out.print(number + ". ");
                                endofline = false;
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    data.get(i).add(cell.getDateCellValue() + "");
                                    System.out.println(cell.getDateCellValue() + "");

                                } else {
                                    data.get(i).add(cell.getNumericCellValue() + "");
                                    System.out.println(cell.getNumericCellValue() + "");
                                    n_value = cell.getNumericCellValue();
                                    if (mapped_object.containsKey(key_map)) {
                                        mapped_object.put(key_map, n_value);
                                    }
                                }
                                break;
                            case BOOLEAN:
                                data.get(i).add(cell.getBooleanCellValue() + "");
                                System.out.println(cell.getBooleanCellValue() + "");
                                endofline = false;
                                break;
                            case FORMULA:
                                data.get(i).add(cell.getCellFormula() + "");
                                // System.out.println(cell.getCellFormula() + "");
                                endofline = false;

                                switch (evaluator.evaluateFormulaCell(cell)) {
                                    case BOOLEAN:
                                        System.out.println(cell.getBooleanCellValue());
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    case NUMERIC:
                                        System.out.println(cell.getNumericCellValue());
                                        s_value = cell.getNumericCellValue() + "";
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    case STRING:
                                        System.out.println(cell.getStringCellValue());
                                        s_value = cell.getStringCellValue();
                                        mapped_object.put(key_map, s_value);
                                        break;
                                    default:
                                        break;
                                }

                                break;
                            default:
                                data.get(new Integer(i)).add(" ");
                                System.out.println("kosong");
                                endofline = true;
                                break;
                        }

                        number++;
                    }
                    if (endofline == false) {

                        System.out.println(mapped_object);
                        newBatch = new ObjectMapper().convertValue(mapped_object, dftr_batch.class);
                        System.out.println(newBatch.getNama());
                        if (rep_batch.findByNoMember(newBatch.getNoMember()) != null) {
                            System.out.println("lama");
                            dftr_batch old_batch = rep_batch.findByNoMember(newBatch.getNoMember());
                            if (!old_batch.getJsonencode().equals(mapped_object.toString())) {
                                System.out.println("berubah");
                                newBatch.setId(old_batch.getId());
                                newBatch.setNamareal(rep_anggota.findById(newBatch.getNoMember()).get().getNama());
                                newBatch.setVersion(old_batch.getVersion() + 1);
                                newBatch.setJsonencode(mapped_object.toString());
                                rep_batch.save(newBatch);
                            }
                        } else {
                            System.out.println("baru");
                            newBatch.setNamareal(rep_anggota.findById(newBatch.getNoMember()).get().getNama());
                            newBatch.setJsonencode(mapped_object.toString());
                            rep_batch.save(newBatch);
                        }

                    } else {
                        break;
                    }

                }

                if (endofline == false) {

                    i++;
                    num_of_row++;
                    System.out.println("next row");

                }

            }
            workbook.close();
            System.out.println("Sukses");
            System.out.println(num_of_row);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}