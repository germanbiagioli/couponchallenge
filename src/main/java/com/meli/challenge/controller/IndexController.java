/**
 * 
 */
package com.meli.challenge.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author german
 *
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public Map<String, String> index() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("Candidate", "German Biagioli");
		result.put("Title", "Challenge: Cupón de compra");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy hh:mm:s");

		result.put("Date", simpleformat.format(cal.getTime()));

		return result;

	}

	@RequestMapping(value = "/ashtml", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String indexAsHtml() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy hh:mm:s");
		return "<html>\n" + "<header><title>MELI</title></header>\n" + "<body>\n"
				+ "<H1> Challenge: Cupón de compra</H1>\n" + "<h3> Candidate: German Biagioli</h3>\n <Label>"
				+ simpleformat.format(cal.getTime()) + "</Label></body>\n" + "</html>";

	}
}
