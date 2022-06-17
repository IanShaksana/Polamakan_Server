package com.example.demo.n_model.file_xlsx;

import java.io.*;
import java.util.*;

import com.example.demo.n_resource.resource_value;
import com.example.demo.project_polamakan.repo.rep_anggota;
import com.example.demo.project_polamakan.table.dftr_anggota;
import com.example.demo.project_polamakan.table.dftr_batch;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.*;

@Component
@Getter
@Setter

public class xlsx_process {

    private Workbook workbook;
    private Sheet sheet;
    private Row header;
    private Cell headercell;

    private Row row_data;
    private int row_number;
    private CellStyle style;
    private Cell cell_data;

    private String fileLoc;
    private String[] header_value;
    @Autowired
    private rep_anggota rep_anggota;

    public xlsx_process(List<String> header_value) {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Sheet 1");
        this.sheet.setColumnWidth(0, 6000);
        this.sheet.setColumnWidth(1, 4000);
        this.header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        this.style = workbook.createCellStyle(); // this.style.setWrapText(true);

        for (int i = 0; i < header_value.size(); i++) {
            this.headercell = header.createCell(i);
            headercell.setCellValue(header_value.get(i));
            headercell.setCellStyle(headerStyle);
        }

        this.row_number = 1;

    }

    FileInputStream file_import;

    public xlsx_process() {
    }

    public xlsx_process(FileInputStream file) {
        file_import = file;
    }

    public void setup() {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Sheet 1");
        for (int i = 0; i < header_value.length; i++) {
            if (header_value[i].strip().equalsIgnoreCase("NO.")) {
                this.sheet.setColumnWidth(i, 1134);
            }
            if (header_value[i].strip().equalsIgnoreCase("NAMA")) {
                this.sheet.setColumnWidth(i, 6838);
            }
            if (header_value[i].strip().equalsIgnoreCase("KODE")) {
                this.sheet.setColumnWidth(i, 1354);
            }
            if (header_value[i].strip().equalsIgnoreCase("SENIN")) {
                this.sheet.setColumnWidth(i, 2486);
            }
            if (header_value[i].strip().equalsIgnoreCase("SELASA")) {
                this.sheet.setColumnWidth(i, 2486);
            }
            if (header_value[i].strip().equalsIgnoreCase("RABU")) {
                this.sheet.setColumnWidth(i, 2486);
            }
            if (header_value[i].strip().equalsIgnoreCase("KAMIS")) {
                this.sheet.setColumnWidth(i, 2486);
            }
            if (header_value[i].strip().equalsIgnoreCase("JUMAT")) {
                this.sheet.setColumnWidth(i, 2486);
            }
            if (header_value[i].strip().equalsIgnoreCase("PILIHAN KARBO")) {
                this.sheet.setColumnWidth(i, 256 * 16);
            }
            if (header_value[i].strip().equalsIgnoreCase("ALERGI DAGING")) {
                this.sheet.setColumnWidth(i, 256 * 18);
            }
            if (header_value[i].strip().equalsIgnoreCase("ALERGI SAYUR")) {
                this.sheet.setColumnWidth(i, 9546);
            }
            if (header_value[i].strip().equalsIgnoreCase("SPECIAL")) {
                this.sheet.setColumnWidth(i, 8858);
            }
            if (header_value[i].strip().equalsIgnoreCase("DUMMY")) {
                this.sheet.setColumnWidth(i, 2486);
            }
        }
        this.header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle(); //
        // headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);

        this.style = workbook.createCellStyle(); // this.style.setWrapText(true);

        for (int i = 0; i < header_value.length; i++) {
            this.headercell = header.createCell(i);
            if (!header_value[i].equals("DUMMY")) {
                headercell.setCellValue(header_value[i]);
                headercell.setCellStyle(headerStyle);
            }
        }
        this.row_number = 1;

    }

    public xlsx_process(String[] header_value) {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Sheet 1");
        for (int i = 0; i < header_value.length; i++) {
            if (header_value[i].strip().equalsIgnoreCase("Tenor (bulan)")) {
                this.sheet.setColumnWidth(i, 3500);
            } else if (header_value[i].strip().equalsIgnoreCase("No Rek Kredit")) {
                this.sheet.setColumnWidth(i, 4500);
            } else {
                this.sheet.setColumnWidth(i, 6500);
            }
        }
        this.header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle(); //
        // headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        headerStyle.setFont(font);

        this.style = workbook.createCellStyle(); // this.style.setWrapText(true);

        for (int i = 0; i < header_value.length; i++) {
            this.headercell = header.createCell(i);
            headercell.setCellValue(header_value[i]);
            headercell.setCellStyle(headerStyle);
        }
        this.row_number = 1;
    }

    public void create_row_batch(List<dftr_batch> batches, String[] key, String option) {
        try {

            boolean condition = true;
            for (dftr_batch batch : batches) {
                dftr_anggota anggota = rep_anggota.findById(batch.getNoMember()).get();
                System.out.println("namanya " + anggota.getNama());

                if (option.strip().equalsIgnoreCase("dinner")) {
                    if (batch.getDinner().strip().equalsIgnoreCase("NO")) {
                        condition = false;
                    } else {
                        condition = true;
                    }
                }

                if (option.strip().equalsIgnoreCase("lunch")) {
                    if (batch.getLunch().strip().equalsIgnoreCase("NO")) {
                        condition = false;
                    } else {
                        condition = true;
                    }
                }

                if (condition) {
                    this.row_data = sheet.createRow(row_number);
                    // this.row_data.setHeightInPoints(39);
                    // Integer size = 0;

                    for (int j = 0; j < key.length; j++) {
                        this.cell_data = this.row_data.createCell(j);
                        String day = null;
                        if (option.strip().equalsIgnoreCase("dinner")) {
                            day = batch.getDinner();
                        }
                        if (option.strip().equalsIgnoreCase("lunch")) {
                            day = batch.getLunch();
                        }
                        XSSFCellStyle defaultStyle = ((XSSFWorkbook) workbook).createCellStyle();
                        defaultStyle.setBorderBottom(BorderStyle.THIN);
                        defaultStyle.setBorderLeft(BorderStyle.THIN);
                        defaultStyle.setBorderRight(BorderStyle.THIN);
                        defaultStyle.setBorderTop(BorderStyle.THIN);
                        defaultStyle.setBorderTop(BorderStyle.THIN);
                        defaultStyle.setWrapText(true);

                        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
                        font.setFontName("Arial");
                        font.setFontHeightInPoints((short) 10);
                        font.setBold(true);
                        defaultStyle.setFont(font);
                        defaultStyle.setVerticalAlignment(VerticalAlignment.TOP);
                        this.cell_data.setCellStyle(defaultStyle);

                        if (key[j].strip().equalsIgnoreCase("NO.")) {
                            // ndak bold
                            font.setFontHeightInPoints((short) 10);
                            font.setBold(false);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            // ndak bold
                            this.cell_data.setCellValue(row_number);
                        }

                        if (key[j].strip().equalsIgnoreCase("NAMA")) {

                            font.setFontHeightInPoints((short) 14);
                            font.setBold(false);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);

                            this.cell_data.setCellValue(anggota.getNama());
                        }

                        if (key[j].strip().equalsIgnoreCase("KODE")) {

                            font.setFontHeightInPoints((short) 10);
                            font.setBold(false);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            this.cell_data.setCellValue(anggota.getJenisPaket());
                        }

                        if (key[j].strip().equalsIgnoreCase("SENIN")) {
                            font.setBold(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            Style_Picker(anggota.getJenisPaket(), defaultStyle);
                            if (day.contains("SENIN") || day.contains("ALL")) {
                                this.cell_data.setCellValue("join");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("SELASA")) {
                            font.setBold(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            Style_Picker(anggota.getJenisPaket(), defaultStyle);
                            if (day.contains("SELASA") || day.contains("ALL")) {
                                this.cell_data.setCellValue("join");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("RABU")) {
                            font.setBold(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            Style_Picker(anggota.getJenisPaket(), defaultStyle);
                            if (day.contains("RABU") || day.contains("ALL")) {
                                this.cell_data.setCellValue("join");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("KAMIS")) {
                            font.setBold(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            Style_Picker(anggota.getJenisPaket(), defaultStyle);
                            if (day.contains("KAMIS") || day.contains("ALL")) {
                                this.cell_data.setCellValue("join");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("JUMAT")) {
                            font.setBold(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            Style_Picker(anggota.getJenisPaket(), defaultStyle);
                            if (day.contains("JUMAT") || day.contains("ALL")) {
                                this.cell_data.setCellValue("join");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("PILIHAN KARBO")) {

                            font.setFontHeightInPoints((short) 12);
                            font.setBold(true);
                            font.setItalic(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            if (!anggota.getPrefKarbo().strip().equalsIgnoreCase("none")) {
                                this.cell_data.setCellValue(anggota.getPrefKarbo());
                            }
                            if (anggota.getPrefKarbo().contains("KEDUANYA")) {
                                this.cell_data.setCellValue("");
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("ALERGI DAGING")) {

                            font.setFontHeightInPoints((short) 12);
                            font.setBold(true);
                            font.setItalic(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            if (!anggota.getAlergiDaging().strip().equalsIgnoreCase("none")) {
                                this.cell_data.setCellValue(anggota.getAlergiDaging());
                            }

                        }

                        if (key[j].strip().equalsIgnoreCase("ALERGI SAYUR")) {

                            font.setFontHeightInPoints((short) 11);
                            font.setBold(true);
                            font.setItalic(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            if (!anggota.getAlergiSayur().strip().equalsIgnoreCase("none")) {
                                this.cell_data.setCellValue(anggota.getAlergiSayur());
                            }

                        }

                        if (key[j].strip().equalsIgnoreCase("SPECIAL")) {

                            font.setFontHeightInPoints((short) 11);
                            font.setBold(true);
                            font.setItalic(true);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);
                            if (!anggota.getSpecialNote().strip().equalsIgnoreCase("none")) {
                                this.cell_data.setCellValue(anggota.getSpecialNote());
                            }

                        }

                        if (key[j].strip().equalsIgnoreCase("DUMMY")) {
                            IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
                            XSSFColor color = new XSSFColor(new java.awt.Color(255, 255, 255), colorMap);
                            font.setBold(false);
                            font.setColor(color);
                            defaultStyle.setBorderBottom(BorderStyle.NONE);
                            defaultStyle.setBorderLeft(BorderStyle.NONE);
                            defaultStyle.setBorderRight(BorderStyle.NONE);
                            defaultStyle.setBorderTop(BorderStyle.NONE);
                            defaultStyle.setBorderTop(BorderStyle.NONE);
                            defaultStyle.setFont(font);
                            this.cell_data.setCellStyle(defaultStyle);

                            this.cell_data.setCellValue("joinnnnnnnnnnnnnnn");

                        }

                        // coba check di re read

                    }

                    row_number++;
                }

            }

            // JSONArray JArray = JObject.getJSONArray("data");
            // for (int i = 0; i < JArray.length(); i++) {

            // JSONObject data = JArray.getJSONObject(i);
            // JSONArray tunggakan = data.getJSONArray("Tunggakan");

            // for (int k = 0; k < tunggakan.length(); k++) {
            // this.row_data = sheet.createRow(row_number);
            // for (int j = 0; j < key.length; j++) {
            // this.cell_data = this.row_data.createCell(j);
            // String col_value = "";
            // this.cell_data.setCellValue(col_value);

            // }
            // this.row_number++;
            // }

            // }
        } catch (

        Exception e) {
            e.printStackTrace();
        }

    }

    public void create_row_kitchen(List<dftr_batch> batches, String[] key, String option) {
        try {

            boolean condition = true;
            for (dftr_batch batch : batches) {
                dftr_anggota anggota = rep_anggota.findById(batch.getNoMember()).get();
                System.out.println(anggota.getJenisPaket());
                if (option.strip().equalsIgnoreCase("dinner")) {
                    if (batch.getDinner().strip().equalsIgnoreCase("NO")) {
                        condition = false;
                    } else {
                        condition = true;
                    }
                }

                if (option.strip().equalsIgnoreCase("lunch")) {
                    if (batch.getLunch().strip().equalsIgnoreCase("NO")) {
                        condition = false;
                    } else {
                        condition = true;
                    }
                }

                if (condition) {
                    this.row_data = sheet.createRow(row_number);
                    for (int j = 0; j < key.length; j++) {
                        this.cell_data = this.row_data.createCell(j);
                        String day = null;
                        if (option.strip().equalsIgnoreCase("dinner")) {
                            day = batch.getDinner();
                        }
                        if (option.strip().equalsIgnoreCase("lunch")) {
                            day = batch.getLunch();
                        }
                        XSSFCellStyle defaultStyle = ((XSSFWorkbook) workbook).createCellStyle();
                        defaultStyle.setBorderBottom(BorderStyle.THIN);
                        defaultStyle.setBorderLeft(BorderStyle.THIN);
                        defaultStyle.setBorderRight(BorderStyle.THIN);
                        defaultStyle.setBorderTop(BorderStyle.THIN);
                        defaultStyle.setBorderTop(BorderStyle.THIN);
                        defaultStyle.setWrapText(true);
                        defaultStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                        this.cell_data.setCellStyle(defaultStyle);
                        // if (key[j].strip().equalsIgnoreCase("No.")) {
                        // this.cell_data.setCellValue(row_number);
                        // }

                        if (key[j].strip().equalsIgnoreCase("Nama")) {

                            this.cell_data.setCellValue(anggota.getNama());
                        }

                        if (key[j].strip().equalsIgnoreCase("No Hape")) {
                            this.cell_data.setCellValue(anggota.getTelp().toString());
                        }

                        if (key[j].strip().equalsIgnoreCase("Alamat " + option)) {
                            if (option.strip().equalsIgnoreCase("lunch")) {
                                this.cell_data.setCellValue(anggota.getAlamatLunch());
                            }
                            if (option.strip().equalsIgnoreCase("dinner")) {
                                if (anggota.getAlamatDinner().strip().equalsIgnoreCase("none")
                                        || anggota.getAlamatDinner().strip().equalsIgnoreCase("SAMA")
                                        || anggota.getAlamatDinner().strip().equalsIgnoreCase("sama")
                                        || anggota.getAlamatDinner().strip().equalsIgnoreCase("Sama")) {
                                    this.cell_data.setCellValue(anggota.getAlamatLunch());
                                } else {

                                    this.cell_data.setCellValue(anggota.getAlamatDinner());
                                }
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("Senin")) {
                            if (day.contains("SENIN") || day.contains("ALL")) {
                                this.cell_data.setCellValue("JOIN");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("Selasa")) {
                            if (day.contains("SELASA") || day.contains("ALL")) {
                                this.cell_data.setCellValue("JOIN");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("Rabu")) {
                            if (day.contains("RABU") || day.contains("ALL")) {
                                this.cell_data.setCellValue("JOIN");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("Kamis")) {
                            if (day.contains("KAMIS") || day.contains("ALL")) {
                                this.cell_data.setCellValue("JOIN");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                        if (key[j].strip().equalsIgnoreCase("Jumat")) {
                            if (day.contains("JUMAT") || day.contains("ALL")) {
                                this.cell_data.setCellValue("JOIN");
                            } else {
                                unjoined_style(defaultStyle, this.cell_data);
                            }
                        }

                    }
                    row_number++;
                }

            }

            // JSONArray JArray = JObject.getJSONArray("data");
            // for (int i = 0; i < JArray.length(); i++) {

            // JSONObject data = JArray.getJSONObject(i);
            // JSONArray tunggakan = data.getJSONArray("Tunggakan");

            // for (int k = 0; k < tunggakan.length(); k++) {
            // this.row_data = sheet.createRow(row_number);
            // for (int j = 0; j < key.length; j++) {
            // this.cell_data = this.row_data.createCell(j);
            // String col_value = "";
            // this.cell_data.setCellValue(col_value);

            // }
            // this.row_number++;
            // }

            // }
        } catch (

        Exception e) {
            e.printStackTrace();
        }

    }

    public boolean output(String batch, String day) {
        File currDir = new File(new resource_value().getOutput_local());
        String path = currDir.getAbsolutePath();
        this.fileLoc = path + "\\" + batch + " " + day + ".xlsx";

        try {
            FileOutputStream outputStream = new FileOutputStream(this.fileLoc);
            this.workbook.write(outputStream);
            this.workbook.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getFileLoc() {
        return fileLoc;
    }

    private void unjoined_style(XSSFCellStyle defaultStyle, Cell cell_data) {
        IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
        XSSFColor color = new XSSFColor(new java.awt.Color(239, 239, 239), colorMap);
        defaultStyle.setFillForegroundColor(color); //
        defaultStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //

        cell_data.setCellStyle(defaultStyle);
    }

    private void Style_Picker(String type, XSSFCellStyle defaultStyle) {
        if (type.strip().equalsIgnoreCase("L")) {
            L_style(defaultStyle, this.cell_data);
        }
        if (type.strip().equalsIgnoreCase("F")) {
            F_style(defaultStyle, this.cell_data);
        }
        if (type.strip().equalsIgnoreCase("M")) {
            M_style(defaultStyle, this.cell_data);
        }
        if (type.strip().equalsIgnoreCase("O")) {
            O_style(defaultStyle, this.cell_data);
        }
    }

    private void L_style(XSSFCellStyle defaultStyle, Cell cell_data) {
        IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
        XSSFColor color = new XSSFColor(new java.awt.Color(217, 234, 211), colorMap);
        defaultStyle.setFillForegroundColor(color); //
        defaultStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //

        cell_data.setCellStyle(defaultStyle);
    }

    private void F_style(XSSFCellStyle defaultStyle, Cell cell_data) {
        IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
        XSSFColor color = new XSSFColor(new java.awt.Color(244, 204, 204), colorMap);
        defaultStyle.setFillForegroundColor(color); //
        defaultStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //

        cell_data.setCellStyle(defaultStyle);
    }

    private void M_style(XSSFCellStyle defaultStyle, Cell cell_data) {
        IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
        XSSFColor color = new XSSFColor(new java.awt.Color(206, 226, 243), colorMap);
        defaultStyle.setFillForegroundColor(color); //
        defaultStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //

        cell_data.setCellStyle(defaultStyle);
    }

    private void O_style(XSSFCellStyle defaultStyle, Cell cell_data) {
        IndexedColorMap colorMap = ((XSSFWorkbook) workbook).getStylesSource().getIndexedColors();
        XSSFColor color = new XSSFColor(new java.awt.Color(255, 242, 204), colorMap);
        defaultStyle.setFillForegroundColor(color); //
        defaultStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); //

        cell_data.setCellStyle(defaultStyle);
    }

}