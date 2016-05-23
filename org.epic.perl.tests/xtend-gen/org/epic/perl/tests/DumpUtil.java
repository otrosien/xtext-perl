package org.epic.perl.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class DumpUtil {
  public String dump(final EObject mod_) {
    return this.dump(mod_, "");
  }
  
  public String dump(final EObject mod_, final String indent) {
    String _string = mod_.toString();
    String _replaceFirst = _string.replaceFirst(".*[.]impl[.](.*)Impl[^(]*", "$1 ");
    String res = (indent + _replaceFirst);
    EList<EObject> _eCrossReferences = mod_.eCrossReferences();
    for (final EObject a : _eCrossReferences) {
      String _res = res;
      String _string_1 = a.toString();
      String _replaceFirst_1 = _string_1.replaceFirst(".*[.]impl[.](.*)Impl[^(]*", "$1 ");
      String _plus = (" ->" + _replaceFirst_1);
      res = (_res + _plus);
    }
    String _res_1 = res;
    res = (_res_1 + "\n");
    EList<EObject> _eContents = mod_.eContents();
    for (final EObject f : _eContents) {
      String _res_2 = res;
      String _dump = this.dump(f, (indent + "    "));
      res = (_res_2 + _dump);
    }
    return res;
  }
}
