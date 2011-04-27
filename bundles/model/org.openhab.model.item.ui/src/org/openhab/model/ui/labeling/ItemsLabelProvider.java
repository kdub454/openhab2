/**
 * openHAB, the open Home Automation Bus.
 * Copyright (C) 2011, openHAB.org <admin@openhab.org>
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7
 *
 * If you modify this Program, or any covered work, by linking or
 * combining it with Eclipse (or a modified version of that library),
 * containing parts covered by the terms of the Eclipse Public License
 * (EPL), the licensors of this Program grant you additional permission
 * to convey the resulting work.
 */

/*
* generated by Xtext
*/
package org.openhab.model.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.openhab.model.items.ModelBinding;
import org.openhab.model.items.ModelGroupItem;
import org.openhab.model.items.ModelItem;
import org.openhab.model.items.ModelNormalItem;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ItemsLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public ItemsLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(ModelItem item) {
		if(item instanceof ModelGroupItem) {
			return "Group " + item.getName();
		}
		if(item instanceof ModelNormalItem) {
			String name = item.getName();
			return ((ModelNormalItem) item).getType() + " " + name;
		}
		return item.getLabel();
	}
	
	String text(ModelBinding binding) {
		return binding.getType();
	}

    String image(ModelItem item) {
		if(item instanceof ModelGroupItem) {
			return "group.png";
		}
		if(item instanceof ModelNormalItem) {
			return ((ModelNormalItem) item).getType().toLowerCase() + ".png";
		}
		return null;
    }

    String image(ModelBinding binding) {
		return "binding.png";
    }
}
