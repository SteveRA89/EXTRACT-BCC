new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("AccessionNumberOutput").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('AccessionNumberOutput')},/+ 
      /${f.get('ruleFinal')},/)
    }
  }