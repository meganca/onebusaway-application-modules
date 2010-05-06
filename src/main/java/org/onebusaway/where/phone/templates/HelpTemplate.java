/*
 * Copyright 2008 Brian Ferris
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.onebusaway.where.phone.templates;

import org.traditionalcake.probablecalls.agitemplates.AbstractAgiTemplate;
import org.traditionalcake.probablecalls.agitemplates.AgiTemplateId;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@AgiTemplateId("/help")
public class HelpTemplate extends AbstractAgiTemplate {

    private static final long serialVersionUID = 1L;

    public HelpTemplate() {
        super(true);
    }

    @Override
    public void buildTemplate(ActionContext context) {

        ValueStack stack = context.getValueStack();
        String message = stack.findString("message");

        if (message != null)
            addMessage(message);
        else
            System.err.println("no message specified");

        addAction(".*\\*","/back");
        
        setNextAction("/back");
    }
}
