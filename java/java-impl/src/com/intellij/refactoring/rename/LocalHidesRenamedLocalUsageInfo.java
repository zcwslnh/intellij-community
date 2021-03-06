/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.refactoring.rename;

import com.intellij.psi.PsiElement;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.refactoring.util.RefactoringUIUtil;
import com.intellij.refactoring.util.CommonRefactoringUtil;
import com.intellij.usageView.UsageViewUtil;

public class LocalHidesRenamedLocalUsageInfo extends UnresolvableCollisionUsageInfo {
  private final PsiElement myConflictingElement;

  public LocalHidesRenamedLocalUsageInfo(PsiElement element, PsiElement conflictingElement) {
    super(element, null);
    myConflictingElement = conflictingElement;
  }

  public String getDescription() {

    PsiElement element = getElement();
    String type = element == null ? "element" : UsageViewUtil.getType(element);
    final String descr = RefactoringBundle.message("there.is.already.a.0.it.will.conflict.with.the.renamed.1",
                                                   RefactoringUIUtil.getDescription(myConflictingElement, true),
                                                   type);
    return CommonRefactoringUtil.capitalize(descr);
  }
}
