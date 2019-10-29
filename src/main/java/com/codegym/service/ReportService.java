package com.codegym.service;

import com.codegym.model.Report;

public interface ReportService {
    Iterable<Report> findAll();

    Report findById(Long id);

    void remove(Long id);

    void save(Report report);
}
