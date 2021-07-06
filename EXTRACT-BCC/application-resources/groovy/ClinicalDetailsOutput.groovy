new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("ClinicalDetails").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('Tag')},${f.get('Pre-opDiagnosis')},"${f.get('Pre-opDiagnosis2')}",${f.get('Pre-opDiagnosisClass')},/+ 
      /${f.get('Pre-opDiagnosisClass2')},${f.get('ExcisionType')},${f.get('ExcisionType2')},${f.get('ExcisionNature')},${f.get('BiopsyProven')},${f.get('Ulcerated')},${f.get('BodyPart')},${f.get('BodyPart2')},${f.get('MultipleScalp')},${f.get('Lateralization')}, ${f.get('UpperOrLower')},${f.get('AnteriorOrPosterior')},${f.get('ProximalOrDistal')},${f.get('MedialOrLateral')},${f.get('PeripheralMarginValue')},${f.get('PeripheralMarginUnit')},${f.get('SupplementalPeripheralMarginClockRange')},${f.get('SupplementalPeripheralMarginClockRange2')},${f.get('DeepMargin')},${f.get('SupplementalDeepMarginClockRange')},${f.get('SupplementalDeepMarginClockRange2')},${f.get('ruleFinal')},/)
    }
  }