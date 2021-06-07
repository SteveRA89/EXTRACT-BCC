new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("MicroMeasurements").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('Tag')},${f.get('MeasurementType')},"${f.get('MeasurementValue')}",${f.get('MeasurementUnit')},/+ 
      /${f.get('PeripheralClockPosition')},${f.get('PeripheralClockPosition2')},${f.get('PeripheralClockPosition3')},${f.get('PeripheralClockPosition4')},${f.get('DeepClockPosition')},${f.get('DeepClockPosition2')},${f.get('DeepClockPosition3')},${f.get('DeepClockPosition4')},${f.get('ruleFinal')},/)
    }
  } 
  //This extracts annotations and features in a csv format (.csv has to be specified in
  // scriptParams when the PR is run). Based on the script in GATE documentation,
  // commenting out the middle line makes it more universal (I think)