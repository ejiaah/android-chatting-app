package com.ejiaah.chattingapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ChatFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var chatPager: ViewPager
    private lateinit var chatPagerAdapter: ChatPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "LifeCycle: onCreateView")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "LifeCycle: onViewCreated")
        super.onViewCreated(view, savedInstanceState)


        listener?.setupToolbar(getString(R.string.title_chatting), mutableListOf(MainActivity.ToolbarContent.TITLE, MainActivity.ToolbarContent.CHARACTER))

        chatPagerAdapter = ChatPagerAdapter(childFragmentManager)
        chatPager = view.findViewById(R.id.chat_pager)
        chatPager.adapter = chatPagerAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.chat_tab)
        tabLayout.setupWithViewPager(chatPager)
    }

    class ChatPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val fragment: Fragment
//            fragment.arguments = Bundle().apply {
//                // Our object is just an integer :-P
//                putInt(ARG_OBJECT, i + 1)
//            }
            when (position) {
                0 -> fragment = RoomFragment()
                else -> fragment = MessageFragment()
            }
            return fragment
        }

        override fun getPageTitle(position: Int): CharSequence {
            when (position) {
                0 -> return "dd"
                else -> return "dddd"
//                0 -> return R.string.friend
//                else -> return R.string.message
            }
        }

        override fun getCount(): Int  = 2

    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        //listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        private const val TAG = "ChatFragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
