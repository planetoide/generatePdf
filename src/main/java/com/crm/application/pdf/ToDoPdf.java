package com.crm.application.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.crm.application.dao.IToDoDao;
import com.crm.application.models.ToDo;
import com.crm.application.models.User;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.*;

@Component("todo/ver")
public class ToDoPdf extends AbstractPdfView {
	@Autowired
	private IToDoDao toDoDao;
	
	public String row;

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		User user = (User) model.get("user");
		List<ToDo> todoList = toDoDao.findAllByUser(user);
		Table table = new Table(2);
		 table.setPadding(5);
		 // encabezado
		 Cell cell = new Cell("Lista de actividades por hacer");
		 cell.setHeader(true);
		 cell.setColspan(2);
		 cell.setBackgroundColor(new Color(222, 221, 217));
		 table.addCell(cell);
		 table.endHeaders();
		 // rows comunes
		 cell = new Cell("Usuario: " + user.getEmail());
		 cell.setColspan(2);
		 cell.setBackgroundColor(new Color(245, 243, 237));
		 table.addCell(cell);
		 table.addCell("Actividad");
		 table.addCell("Pendiente");
		 for (ToDo toDo : todoList) {
			 table.addCell(toDo.getDescription());
			 if(toDo.getIsDone()) {
				 table.addCell("Realizada");
			 } else {
				 table.addCell("Por hacer");
			 }
		}
		 
		
		document.add(table);
		      document.close();
	}

}
