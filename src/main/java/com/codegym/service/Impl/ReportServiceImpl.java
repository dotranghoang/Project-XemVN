package com.codegym.service.Impl;

import com.codegym.model.Report;
import com.codegym.repository.ReportRepository;
import com.codegym.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Iterable<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report findById(Long id) {
        return reportRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        reportRepository.delete(id);
    }

    @Override
    public void save(Report report) {
        reportRepository.save(report);
    }
}
