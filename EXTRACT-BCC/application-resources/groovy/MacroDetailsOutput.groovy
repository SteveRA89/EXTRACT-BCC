new File(scriptParams.outputFile).withWriterAppend{ out ->
  doc.getAnnotations("Output").get("MacroDetails").each{
    anno ->
      def f = anno.getFeatures()
      String[] id =  doc.getFeatures().get("gate.SourceURL").split("/")
      out.writeLine(/${id[-1]},${anno.start()},${anno.end()},/+ 
      /${f.get('Tag')},${f.get('Pre-opDiagnosis')},"${f.get('Pre-opDiagnosis2')}",${f.get('Ulcerated')},/+ 
      /${f.get('ExcisionType')},${f.get('ExcisionType2')},${f.get('ExcisionNature')},${f.get('BodyPart')},${f.get('BodyPart2')},${f.get('MultipleScalp')},${f.get('Lateralization')}, ${f.get('UpperOrLower')},${f.get('AnteriorOrPosterior')},${f.get('ProximalOrDistal')},${f.get('MedialOrLateral')},${f.get('3DSpecimenSize')},${f.get('3DSpecimenSize2')},${f.get('3DSpecimenSize3')},${f.get('3DSpecimenSize4')},${f.get('SpecimenMeasurementUnit')},${f.get('MaxMacroTumourDiameter')},${f.get('MaxMacroMeasurementUnit')},${f.get('ruleFinal')},/)
    }
  }