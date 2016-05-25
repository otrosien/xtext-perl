package org.epic.perl.tests

import org.eclipse.emf.ecore.EObject

class DumpUtil {

    def String dump(EObject mod_) {
        return dump(mod_, "")
    }

    def String dump(EObject mod_, String indent) {
        var res = indent + mod_.toString.replaceFirst('.*[.]impl[.](.*)Impl[^(]*', '$1 ')

        for (a : mod_.eCrossReferences)
            res += ' ->' + a.toString().replaceFirst('.*[.]impl[.](.*)Impl[^(]*', '$1 ')
        res += "\n"
        for (f : mod_.eContents) {
            res += f.dump(indent + "    ")
        }
        return res
    }
}
