/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009, Arnaud Roques
 *
 * Project Info:  http://plantuml.sourceforge.net
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * Original Author:  Arnaud Roques
 * 
 * Revision $Revision: 7170 $
 *
 */
package net.sourceforge.plantuml.skin.bluemodern;

import java.awt.geom.Dimension2D;

import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.skin.AbstractComponent;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.URectangle;

public class ComponentBlueModernActiveLine extends AbstractComponent {

	private final int shadowview = 3;
	private final HtmlColor foregroundColor;

	public ComponentBlueModernActiveLine(HtmlColor foregroundColor, boolean closeUp, boolean closeDown) {
		this.foregroundColor = foregroundColor;
	}

	@Override
	protected void drawInternalU(UGraphic ug, Dimension2D dimensionToUse, boolean withShadow) {
		final StringBounder stringBounder = ug.getStringBounder();
		final int x = (int) (dimensionToUse.getWidth() - getPreferredWidth(stringBounder)) / 2;
		final ShadowShape shadowShape = new ShadowShape(getPreferredWidth(stringBounder), dimensionToUse.getHeight()
				- shadowview, 3);
		ug.translate(shadowview, shadowview);
		shadowShape.drawU(ug);
		ug.translate(-shadowview, -shadowview);

		ug.getParam().setColor(foregroundColor);
		ug.getParam().setBackcolor(foregroundColor);
		ug.draw(x, 0, new URectangle(getPreferredWidth(stringBounder), dimensionToUse.getHeight() - shadowview));
	}

	@Override
	public double getPreferredHeight(StringBounder stringBounder) {
		return 0;
	}

	@Override
	public double getPreferredWidth(StringBounder stringBounder) {
		return 10;
	}

}
