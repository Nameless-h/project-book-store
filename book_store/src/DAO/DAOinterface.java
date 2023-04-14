/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ASUS
 */

import java.util.ArrayList;


public interface DAOinterface<T> {
	public int insert(T t);
	public int update(T t);
	public int delete(T t);
	public int delete_all();
	public ArrayList<T> selecAll();
	public T selectById(T t);
	public ArrayList<T> selecByCondition(String condition);
	
}

