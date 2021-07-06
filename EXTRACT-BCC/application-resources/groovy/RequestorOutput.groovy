new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("Requestor").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('CliniciansName')},"${f.get('Speciality')}",/+ 
      /${f.get('ruleFinal')},/)
    }
  }