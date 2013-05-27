package lizj.fragmento;

import lizj.fragmento.lib.CompatTab;
import lizj.fragmento.lib.CompatTabListener;
import lizj.fragmento.lib.TabCompatActivity;
import lizj.fragmento.lib.TabHelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends TabCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHelper tabHelper = getTabHelper();

		CompatTab homeTab = tabHelper
				.newTab("home")
				.setText(R.string.title_section1)
				.setIcon(R.drawable.icon_home)
				.setTabListener(
						new InstantiatingTabListener(this, HomeFragment.class));
		tabHelper.addTab(homeTab);

		CompatTab bagTab = tabHelper
				.newTab("bag")
				.setText(R.string.title_section2)
				.setIcon(R.drawable.icon_bag)
				.setTabListener(
						new InstantiatingTabListener(this, BagFragment.class));
		tabHelper.addTab(bagTab);

		CompatTab styleTab = tabHelper
				.newTab("bag")
				.setText(R.string.title_section3)
				.setIcon(R.drawable.icon_style)
				.setTabListener(
						new InstantiatingTabListener(this, StyleFragment.class));
		tabHelper.addTab(styleTab);
	}

	/**
	 * Implementation of {@link CompatTabListener} to handle tab change events.
	 * This implementation instantiates the specified fragment class with no
	 * arguments when its tab is selected.
	 */
	public static class InstantiatingTabListener implements CompatTabListener {

		private final TabCompatActivity mActivity;
		private final Class mClass;

		/**
		 * Constructor used each time a new tab is created.
		 * 
		 * @param activity
		 *            The host Activity, used to instantiate the fragment
		 * @param cls
		 *            The class representing the fragment to instantiate
		 */
		public InstantiatingTabListener(TabCompatActivity activity,
				Class<? extends Fragment> cls) {
			mActivity = activity;
			mClass = cls;
		}

		/* The following are each of the ActionBar.TabListener callbacks */
		@Override
		public void onTabSelected(CompatTab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			Fragment fragment = tab.getFragment();
			if (fragment == null) {
				// If not, instantiate and add it to the activity
				fragment = Fragment.instantiate(mActivity, mClass.getName());
				tab.setFragment(fragment);
				ft.add(android.R.id.tabcontent, fragment, tab.getTag());
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(fragment);
			}
		}

		@Override
		public void onTabUnselected(CompatTab tab, FragmentTransaction ft) {
			Fragment fragment = tab.getFragment();
			if (fragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(fragment);
			}
		}

		@Override
		public void onTabReselected(CompatTab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Do nothing.
		}
	}

	public static class HomeFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(R.string.title_section1);
			return textView;
		}
	}

	public static class BagFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(R.string.title_section2);
			return textView;
		}
	}

	public static class StyleFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(R.string.title_section3);
			return textView;
		}
	}

}
