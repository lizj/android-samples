package charly.garcia.viernes3am;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int MENU3 = 1;
	private static final int MENU4 = 2;
	private static final int SUBMENU1 = 3;
	private static final int SUBMENU2 = 4;
	private static final int SUBMENU3 = 5;
	private static final int GROUP1 = 6;
	private static final int MENU5 = 7;
	private static final int MENU6 = 8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.w("ANDROID MENU TUTORIAL:", "onCreate(Bundle savedInstanceState)");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		Log.w("ANDROID MENU TUTORIAL:", "onCreateOptionsMenu(Menu menu)");

		MenuItem menu3 = menu.add(Menu.NONE, MENU3, 3, "Menu No. 3");
		menu3.setAlphabeticShortcut('c');

		SubMenu menu4 = menu.addSubMenu(Menu.NONE, MENU4, 4, "Menu No. 4");
		menu4.add(GROUP1, SUBMENU1, 1, "SubMenu No. 1");
		menu4.add(GROUP1, SUBMENU2, 2, "SubMenu No. 2");
		menu4.setGroupCheckable(GROUP1, true, true);

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {

		Log.w("ANDROID MENU TUTORIAL:", "onPrepareOptionsMenu(Menu menu)");
		MenuItem menu5 = menu.findItem(MENU5);
		if (menu5 == null) {
			menu5 = menu.add(Menu.NONE, MENU5, 5, "Menu No. 5");
		}
		MenuItem menu6 = menu.findItem(MENU6);
		if (menu6 == null) {
			menu6 = menu.add(Menu.NONE, MENU6, 5, "Menu No. 6");
		}

		MenuItem menu2 = menu.findItem(R.id.menu2);
		SubMenu subMenu2 = menu2.getSubMenu();

		MenuItem subMenuItem3 = menu.findItem(SUBMENU3);
		if (subMenuItem3 == null) {
			subMenu2.add(R.id.group2, SUBMENU3, 3, "SubMenu No. 3");
			subMenu2.setGroupCheckable(R.id.group2, true, true);
		}

		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		Log.w("ANDROID MENU TUTORIAL:", "onOptionsItemSelected(MenuItem item)");

		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu1:
			Toast.makeText(this, "Clicked: Menu No. 1", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.menu2:
			Toast.makeText(this, "Clicked: Menu No. 2", Toast.LENGTH_SHORT)
					.show();
			return true;
		case R.id.submenu1:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			Toast.makeText(this, "Clicked: Menu No. 2 - SubMenu No .1",
					Toast.LENGTH_SHORT).show();
			return true;
		case R.id.submenu2:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			Toast.makeText(this, "Clicked: Menu No. 2 - SubMenu No .2",
					Toast.LENGTH_SHORT).show();
			return true;
		case MENU3:
			Toast.makeText(this, "Clicked: Menu No. 3", Toast.LENGTH_SHORT)
					.show();
			return true;
		case SUBMENU1:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			Toast.makeText(this, "Clicked: Menu No. 4 - SubMenu No .1",
					Toast.LENGTH_SHORT).show();
			return true;
		case SUBMENU2:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			Toast.makeText(this, "Clicked: Menu No. 4 - SubMenu No .2",
					Toast.LENGTH_SHORT).show();
			return true;
		case SUBMENU3:
			if (item.isChecked())
				item.setChecked(false);
			else
				item.setChecked(true);
			Toast.makeText(this, "Clicked: Menu No. 2 - SubMenu No .3",
					Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
