new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("SupplementaryReport").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('Tag')},${f.get('SRCancerType')},"${f.get('SRCancerType2')}",${f.get('SRBCCClass')},/+ 
      /${f.get('SRBCCClass2')},${f.get('SRBCCClass3')},${f.get('SRBCCClass4')},${f.get('SRDifferentiation')},${f.get('SRDifferentiation2')},${f.get('SRUlcerated')},${f.get('SRLymphovascularInvasion')},${f.get('SRPerineuralInvasion')},${f.get('SRExcisionCompleted')},${f.get('SRRe-excisionOutcome')}, ${f.get('SRRecurrentOutcome')},${f.get('SRLevelOfInvasion')},${f.get('SRClarkLevel')},${f.get('SRStage')},${f.get('SRPeripheralClear')},${f.get('SRPeripheralClearButClose')},${f.get('SRSupplementalPeripheral')},${f.get('SRDeepClear')},${f.get('SRDeepClearButClose')},${f.get('SRSupplementalDeep')},${f.get('SRFrozenSectionOutcome')}, ${f.get('SRDayDate')},${f.get('SRMonthDate')},${f.get('SRYearDate')},${f.get('SRPathologist')},${f.get('ruleFinal')},/)
    }
  }