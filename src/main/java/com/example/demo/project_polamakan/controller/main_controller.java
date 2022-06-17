package com.example.demo.project_polamakan.controller;

import java.io.*;
import java.util.*;

import com.example.demo.n_model.file_xlsx.*;
import com.example.demo.project_polamakan.repo.*;
import com.example.demo.project_polamakan.table.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.n_model.response.http_response;
import com.example.demo.n_resource.resource_value;

@RestController
@RequestMapping(path = "/api/excel/")
public class main_controller {
    @Autowired
    private xlsx xlsx;
    @Autowired
    private xlsx_process xlsx_process;
    @Autowired
    private rep_batch rep_batch;
    @Autowired
    private rep_anggota rep_anggota;

    @GetMapping(path = "/read/anggota")
    public ResponseEntity<http_response> anggota(@RequestParam String name, @RequestParam Integer sheetno) {

        http_response resp = new http_response();
        try {
            System.out.println("masuk sini");
            File currDir = new File(new resource_value().getInput_local());
            String path = currDir.getAbsolutePath();
            String fileLoc = path + "\\" + name + ".xlsx";
            FileInputStream file = new FileInputStream(fileLoc);

            // do something
            if (xlsx.readAnggota(sheetno, file)) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());
    }

    @GetMapping(path = "/read/batch")
    public ResponseEntity<http_response> batch(@RequestParam String name) {

        http_response resp = new http_response();
        try {
            rep_batch.deleteAll();

            File currDir = new File(new resource_value().getInput_local());
            String path = currDir.getAbsolutePath();
            String fileLoc = path + "\\" + name + ".xlsx";
            FileInputStream file = new FileInputStream(fileLoc);

            // do something
            if (xlsx.readBatch(0, file)) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());
    }

    @GetMapping(path = "/batch/lunch/make/excel")
    public ResponseEntity<http_response> make_batch_lunch(@RequestParam String batch) {

        http_response resp = new http_response();
        try {
            // do something
            String[] header_value = { "NO.", "NAMA", "KODE", "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT",
                    "PILIHAN KARBO", "ALERGI DAGING", "ALERGI SAYUR", "SPECIAL", "DUMMY" };

            xlsx_process.setHeader_value(header_value);
            xlsx_process.setup();

            List<dftr_batch> all = rep_batch.findByBatchNumberOrderByNama(batch);
            List<dftr_batch> all_sorted = new ArrayList<>();
            Integer L_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                // System.out.println(anggota.getJenisPaket());
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("L")) {
                    all_sorted.add(dftr_batch);
                    L_no++;
                }
            }

            Integer F_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("F")) {
                    all_sorted.add(dftr_batch);
                    F_no++;
                }
            }

            Integer M_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("M")) {
                    all_sorted.add(dftr_batch);
                    M_no++;
                }
            }

            Integer O_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("O")) {
                    all_sorted.add(dftr_batch);
                    O_no++;
                }
            }
            System.out.println("L : "+L_no);
            System.out.println("F : "+F_no);
            System.out.println("M : "+M_no);
            System.out.println("O : "+O_no);

            xlsx_process.create_row_batch(all_sorted, header_value, "lunch");

            if (xlsx_process.output(batch, "lunch")) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());

    }

    @GetMapping(path = "/batch/dinner/make/excel")
    public ResponseEntity<http_response> make_batch_dinner(@RequestParam String batch) {

        http_response resp = new http_response();
        try {
            // do something
            String[] header_value = { "NO.", "NAMA", "KODE", "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT",
                    "PILIHAN KARBO", "ALERGI DAGING", "ALERGI SAYUR", "SPECIAL", "DUMMY" };

            xlsx_process.setHeader_value(header_value);
            xlsx_process.setup();
            
            List<dftr_batch> all = rep_batch.findByBatchNumberOrderByNama(batch);
            List<dftr_batch> all_sorted = new ArrayList<>();
            Integer L_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                // System.out.println(anggota.getJenisPaket());
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("L")) {
                    all_sorted.add(dftr_batch);
                    L_no++;
                }
            }

            Integer F_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("F")) {
                    all_sorted.add(dftr_batch);
                    F_no++;
                }
            }

            Integer M_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("M")) {
                    all_sorted.add(dftr_batch);
                    M_no++;
                }
            }

            Integer O_no = 0;
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("O")) {
                    all_sorted.add(dftr_batch);
                    O_no++;
                }
            }
            System.out.println("L : "+L_no);
            System.out.println("F : "+F_no);
            System.out.println("M : "+M_no);
            System.out.println("O : "+O_no);
            
            xlsx_process.create_row_batch(all_sorted, header_value, "dinner");

            if (xlsx_process.output(batch, "dinner")) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());

    }

    @GetMapping(path = "/delivery/lunch/make/excel")
    public ResponseEntity<http_response> make_deliv_lunch(@RequestParam String batch) {

        http_response resp = new http_response();
        try {
            // do something
            String[] header_value = { "Nama", "No Hape", "Alamat lunch", "Senin", "Selasa", "Rabu", "Kamis", "Jumat" };

            xlsx_process.setHeader_value(header_value);
            xlsx_process.setup();

            List<dftr_batch> all = rep_batch.findByBatchNumberOrderByNama(batch);

            List<dftr_batch> all_sorted = new ArrayList<>();
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                System.out.println(anggota.getJenisPaket());
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("L")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("F")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("M")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("O")) {
                    all_sorted.add(dftr_batch);
                }
            }

            all_sorted = rep_batch.findalamatlunch(batch);
            xlsx_process.create_row_kitchen(all_sorted, header_value, "lunch");

            if (xlsx_process.output(batch, "delivery_lunch")) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());

    }

    @GetMapping(path = "/delivery/dinner/make/excel")
    public ResponseEntity<http_response> make_deliv_dinner(@RequestParam String batch) {

        http_response resp = new http_response();
        try {
            // do something
            String[] header_value = { "Nama", "No Hape", "Alamat dinner", "Senin", "Selasa", "Rabu", "Kamis", "Jumat" };

            xlsx_process.setHeader_value(header_value);
            xlsx_process.setup();

            List<dftr_batch> all = rep_batch.findByBatchNumberOrderByNama(batch);
            List<dftr_batch> all_sorted = new ArrayList<>();
            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                System.out.println(anggota.getJenisPaket());
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("L")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("F")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("M")) {
                    all_sorted.add(dftr_batch);
                }
            }

            for (dftr_batch dftr_batch : all) {
                dftr_anggota anggota = rep_anggota.findById(dftr_batch.getNoMember()).get();
                if (anggota.getJenisPaket().strip().equalsIgnoreCase("O")) {
                    all_sorted.add(dftr_batch);
                }
            }

            all_sorted = rep_batch.findalamatdinner(batch);
            xlsx_process.create_row_kitchen(all_sorted, header_value, "dinner");

            if (xlsx_process.output(batch, "delivery_dinner")) {
                resp.setSuccess();
            } else {
                resp.setFail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.setFail();
        }
        return new ResponseEntity<>(resp, resp.getStatuscode());

    }

}