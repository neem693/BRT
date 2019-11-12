package com.theComments.brt.jpa.theComment.dao;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;

public interface Evaluation_item_dao extends JpaRepository<Evaluation_item, Long> {

	
}
