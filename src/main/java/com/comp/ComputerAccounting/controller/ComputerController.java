package com.comp.ComputerAccounting.controller;

import com.comp.ComputerAccounting.model.Computer;
import com.comp.ComputerAccounting.model.OperationSystem;
import com.comp.ComputerAccounting.service.ComputerService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ComputerController {

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping("/computer-list/{id}")
    public String findAll(@PathVariable("id") Integer id, Model model){
        Computer computer = computerService.findComputerById(id);
        model.addAttribute("computer", computer);
        return "/computerList";
    }

    @GetMapping("/computer-create")
    public String createComputerForm(Computer computer){
        return "/computer-create";
    }

    @PostMapping("/computer-create")
    public String createComputer(Computer computer){
        computerService.saveComputer(computer);
        return "redirect:/computerList";
    }

    @GetMapping("/computer-delete/{id}")
    public String deleteComputer(@PathVariable("id") Integer id){
        computerService.deleteComputerById(id);
        return "redirect:/computerList";
    }

    @GetMapping("computer-update/{id}")
    public String updateComputerForm(@PathVariable("id") Integer id, Model model){
        Computer computer = computerService.findComputerById(id);
        model.addAttribute("computer", computer);
        return "/computer-update";
    }

    @PostMapping("/computer-update")
    public String updateComputer(Computer computer){
        computerService.saveComputer(computer);
        return "redirect:/computerList";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Computer> result = computerService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }

    @GetMapping("/export/{id}")
    public void export(@PathVariable("id") Integer integer, HttpServletResponse response) throws Exception {

        // user list
        Computer computer = computerService.findComputerById(integer);

        Workbook workbook = new XSSFWorkbook();
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy"));
        Sheet sheet = workbook.createSheet("Computer");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Ім'я комп'ютера в локальній мережі: ");
        Row aRow = sheet.createRow(1);
        aRow.createCell(0).setCellValue(computer.getComputerNameInLocalNetwork());

        Row header1 = sheet.createRow(3);
        header1.createCell(0).setCellValue("Список операційних систем:");
        header1.createCell(5).setCellValue("Приорітет ОС:");
        int rowC=4;
        for (int i=0; i<computer.getComputerOS().size();i++) {
            Row bRow = sheet.createRow(rowC++);
            bRow.createCell(0).setCellValue(computer.getComputerOS().get(i).getOperationSystem().getTypeOSname());
            bRow.createCell(5).setCellValue(computer.getComputerOS().get(i).getPriorityOS());
        }

        Row header2 = sheet.createRow(computer.getComputerOS().size() + rowC);
        header2.createCell(0).setCellValue("Список програмного забезпечення:");
        header2.createCell(4).setCellValue("Розмір програми:");
        header2.createCell(6).setCellValue("Дата встановки:");
        header2.createCell(8).setCellValue("Місце встановки:");
        header2.createCell(11).setCellValue("Фахівець встановник, Ім'я:");
        header2.createCell(14).setCellValue("Фахівець встановник, Прізвище:");
        header2.createCell(18).setCellValue("Електрона адресса фахівця:");
        int rowD = computer.getComputerOS().size() + rowC;
        for (int i=0; i<computer.getSoftwareInstallations().size();i++) {
            Row DRow = sheet.createRow(rowD++);
            Row KRow = sheet.createRow(rowD++);
            DRow.createCell(0).setCellValue(computer.getSoftwareInstallations().get(i).getProgram().getProgramName());
            DRow.createCell(4).setCellValue(computer.getSoftwareInstallations().get(i).getProgramSize());
            Cell cell = DRow.createCell(6);
            cell.setCellValue(computer.getSoftwareInstallations().get(i).getDateOfInstallation());
            cell.setCellStyle(cellStyle);
            DRow.createCell(8).setCellValue(computer.getSoftwareInstallations().get(i).getProgram().getInstallationLocation());
            DRow.createCell(11).setCellValue(computer.getSoftwareInstallations().get(i).getSpecialists().getName());
            DRow.createCell(14).setCellValue(computer.getSoftwareInstallations().get(i).getSpecialists().getSurname());
            DRow.createCell(18).setCellValue(computer.getSoftwareInstallations().get(i).getSpecialists().getEmail());
        }

        Row header3 = sheet.createRow(computer.getSoftwareInstallations().size()+rowD-1);
        header3.createCell(0).setCellValue("Серійний номер:");
        header3.createCell(3).setCellValue("Модель:");
        header3.createCell(7).setCellValue("Тип обладнання:");
        int rowE = computer.getSoftwareInstallations().size()+rowD;
        for (int i=0; i<computer.getComputerEquipments().size();i++) {
            Row eRow = sheet.createRow(rowE++);
            eRow.createCell(0).setCellValue(computer.getComputerEquipments().get(i).getPeripheralEquipment().getSerialNumberOfTheEquipment());
            eRow.createCell(3).setCellValue(computer.getComputerEquipments().get(i).getPeripheralEquipment().getModelOfEquipment());
            eRow.createCell(7).setCellValue(computer.getComputerEquipments().get(i).getPeripheralEquipment().getTypeOfPeripheralEquipment().getNameTypePeripheralEquipment());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("content-disposition", "attachment; filename=myfile.xlsx");
        workbook.write(response.getOutputStream());
    }
}

