package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theComments.brt.jpa.dto.EvaluateDto;
import com.theComments.brt.jpa.theComment.model.Evaluate;

public interface Evaluate_dao extends JpaRepository<Evaluate, Long> {


}
