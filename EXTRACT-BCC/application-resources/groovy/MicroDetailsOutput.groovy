new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("MicroDetails").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('Tag')},${f.get('ExcisionType')},"${f.get('ExcisionType2')}",${f.get('CancerType')},/+ 
      /${f.get('CancerType2')},${f.get('BCCClass')},${f.get('BCCClass2')},${f.get('BCCClass3')},${f.get('BCCClass4')},${f.get('Differentiation')},${f.get('Differentiation2')},${f.get('Ulcerated')},${f.get('LymphovascularInvasion')},${f.get('PerineuralInvasion')}, ${f.get('ExcisionCompleted')},${f.get('Re-excisionOutcome')},${f.get('RecurrentOutcome')},${f.get('LevelOfInvasion')},${f.get('ClarkLevel')},${f.get('Stage')},${f.get('PeripheralClear')},${f.get('PeripheralClearButClose')},${f.get('PeripheralClose')},${f.get('SupplementalPeripheral')},${f.get('DeepClear')},${f.get('DeepClearButClose')},${f.get('DeepClose')},${f.get('SupplementalDeep')},${f.get('FrozenSectionOutcome')},${f.get('ruleFinal')},/)
    }
  }