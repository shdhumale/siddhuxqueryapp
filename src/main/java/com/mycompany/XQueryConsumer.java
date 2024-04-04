package com.mycompany;
import java.io.File;

import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

public class XQueryConsumer {

    public static void main(String[] args) throws Exception {
    	Processor processor = new Processor(false); // Use false for Saxon-HE
    	DocumentBuilder documentBuilder = processor.newDocumentBuilder();
    	XdmNode sourceDocument = documentBuilder.build(new File("C:\\STS-Workspace\\siddhuxqueryapp\\src\\main\\resources\\course.xml"));
    	XQueryCompiler compiler = processor.newXQueryCompiler();
    	XQueryExecutable executable = compiler.compile(new File("C:\\STS-Workspace\\siddhuxqueryapp\\src\\main\\resources\\courses.xqy"));
    	XQueryEvaluator evaluator = executable.load();
    	evaluator.setContextItem(sourceDocument); // Set the source document as the context item
    	// Set any other execution options as needed
    	XdmValue result = evaluator.evaluate(); // Execute the query
    	for (XdmItem item : result) {
    	    System.out.println(item.getStringValue());
    	}

    	
    }
}