package com.example.a55014.mytest.geogebra.share.serialize;

import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.ArrayAtom;
import com.example.a55014.mytest.geogebra.share.ArrayOfAtoms;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.BigOperatorAtom;
import com.example.a55014.mytest.geogebra.share.BreakMarkAtom;
import com.example.a55014.mytest.geogebra.share.CharAtom;
import com.example.a55014.mytest.geogebra.share.ColorAtom;
import com.example.a55014.mytest.geogebra.share.EmptyAtom;
import com.example.a55014.mytest.geogebra.share.FencedAtom;
import com.example.a55014.mytest.geogebra.share.FractionAtom;
import com.example.a55014.mytest.geogebra.share.HlineAtom;
import com.example.a55014.mytest.geogebra.share.JavaFontRenderingAtom;
import com.example.a55014.mytest.geogebra.share.NthRoot;
import com.example.a55014.mytest.geogebra.share.PhantomAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.ScriptsAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.SymbolAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TypedAtom;
import com.example.a55014.mytest.geogebra.share.VRowAtom;
import com.example.a55014.mytest.geogebra.share.platform.FactoryProvider;

/**
 * Converts parsed LaTeX to GGB syntax
 * 
 * @author Zbynek
 *
 */
public class TeXAtomSerializer {
	private BracketsAdapterI adapter;

	/**
	 * @param ad
	 *            adapter
	 */
	public TeXAtomSerializer(BracketsAdapterI ad) {
		this.adapter = ad == null ? new DefaultBracketsAdapter() : ad;
	}

	/**
	 * @param root
	 *            tex formula
	 * @return expression in GeoGebra syntax
	 */
	public String serialize(Atom root) {

		// FactoryProvider.debugS("root = " + root.getClass());
		if (root instanceof FractionAtom) {
			FractionAtom frac = (FractionAtom) root;
			return "(" + serialize(frac.getNumerator()) + ")/("
					+ serialize(frac.getDenominator()) + ")";
		}
		if (root instanceof NthRoot) {
			NthRoot nRoot = (NthRoot) root;
			if (nRoot.getRoot() == null) {
				return "sqrt(" + serialize(nRoot.getTrueBase()) + ")";
			}
			return "nroot(" + serialize(nRoot.getTrueBase()) + ","
					+ serialize(nRoot.getRoot()) + ")";
		}
		if (root instanceof CharAtom) {
			CharAtom ch = (CharAtom) root;
			return ch.getCharacter() + "";
		}
		if (root instanceof TypedAtom) {
			TypedAtom ch = (TypedAtom) root;
			return serialize(ch.getBase());
		}
		if (root instanceof ScriptsAtom) {
			ScriptsAtom ch = (ScriptsAtom) root;
			return subSup(ch);
		}
		if (root instanceof FencedAtom) {
			FencedAtom ch = (FencedAtom) root;
			String left = serialize(ch.getLeft());
			String right = serialize(ch.getRight());
			String base = serialize(ch.getTrueBase());
			return adapter.transformBrackets(left, base, right);
		}
		if (root instanceof SpaceAtom) {
			return " ";
		}
		if (root instanceof EmptyAtom || root instanceof BreakMarkAtom
				|| root instanceof PhantomAtom) {
			return "";
		}
		if (root instanceof SymbolAtom) {

			SymbolAtom ch = (SymbolAtom) root;
			String out = ch.getUnicode() + "";
			if ("\u00b7".equals(out)) {
				return "*";
			}
			return out;

		}
		if (root instanceof RowAtom) {
			RowAtom row = (RowAtom) root;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; row.getElement(i) != null; i++) {
				sb.append(serialize(row.getElement(i)));
			}
			return sb.toString();
		}
		if (root instanceof AccentedAtom) {
			SymbolAtom accent = ((AccentedAtom) root).getAccent();
			String content = serialize(((AccentedAtom) root).getBase());
			if (accent == Symbols.VEC) {
				return " vector " + content;
			}
			return content + " with " + accent.getUnicode();
		}
		if (root instanceof VRowAtom) {
			VRowAtom row = (VRowAtom) root;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; row.getElement(i) != null; i++) {
				sb.append(serialize(row.getElement(i)));
				sb.append(" new line ");
			}
			return sb.toString();
		}

		if (root instanceof HlineAtom) {
			return "";
		}

		if (root instanceof ColorAtom) {
			ColorAtom row = (ColorAtom) root;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; row.getElement(i) != null; i++) {
				sb.append(serialize(row.getElement(i)));
			}
			return sb.toString();
		}

		if (root instanceof JavaFontRenderingAtom) {
			return ((JavaFontRenderingAtom) root).getString();
		}

		// serialise table to eg {{1,2,3},{3,4,5}}
		if (root instanceof ArrayAtom) {
			ArrayAtom atom = (ArrayAtom) root;
			ArrayOfAtoms matrix = atom.getMatrix();
			int rows = matrix.getRows();
			int cols = matrix.getCols();

			StringBuilder sb = new StringBuilder();
			sb.append('{');
			for (int row = 0; row < rows; row++) {
				sb.append('{');
				for (int col = 0; col < cols; col++) {
					sb.append(serialize(matrix.get(row, col)));

					if (col < cols - 1) {
						sb.append(",");
					}
				}
				sb.append("}");

				if (row < rows - 1) {
					sb.append(",");
				}
			}
			sb.append('}');

			return sb.toString();
		}

		if (root instanceof BigOperatorAtom) {
			BigOperatorAtom bigOp = (BigOperatorAtom) root;
			return serialize(bigOp.getTrueBase()) + " from " + serialize(bigOp.getBottom()) + " to "
					+ serialize(bigOp.getTop());
		}
		
		// BoldAtom, ItAtom, TextStyleAtom, StyleAtom, RomanAtom
		// TODO: probably more atoms need to implement HasTrueBase
		if (root instanceof HasTrueBase) {
			return serialize(((HasTrueBase) root).getTrueBase());
		}

		FactoryProvider.debugS("Unhandled atom:"
				+ (root == null ? "null" : (root.getClass() + " " + root.toString())));
		// FactoryProvider.getInstance().printStacktrace();

		return "?";
	}

	private String subSup(ScriptsAtom script) {
		StringBuilder sb = new StringBuilder(serialize(script.getTrueBase()));
		if (script.getSub() != null) {
			String sub = serialize(script.getSub());
			sb.append(adapter.subscriptContent(sub));
		}
		if (script.getSup() != null) {
			sb.append("^(");
			sb.append(serialize(script.getSup()));
			sb.append(")");
		}
		return sb.toString();
	}

}
