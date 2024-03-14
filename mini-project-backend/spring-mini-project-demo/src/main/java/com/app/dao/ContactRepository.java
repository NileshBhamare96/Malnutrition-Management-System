package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
