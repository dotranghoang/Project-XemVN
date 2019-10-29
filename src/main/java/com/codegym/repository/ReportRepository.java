package com.codegym.repository;

import com.codegym.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReportRepository extends PagingAndSortingRepository<Report,Long> {
}
