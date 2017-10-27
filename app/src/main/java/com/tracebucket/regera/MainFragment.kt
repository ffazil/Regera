package com.tracebucket.regera

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private val TAG:String = "MainFragment"
    private var mListener: OnFragmentInteractionListener? = null
    private lateinit var invoices: List<Invoice>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataSet()
    }

    private fun initDataSet() {
        invoices = mutableListOf<Invoice>(
                Invoice("35.00", "Acme Inc.", "19237A", "28-Sep-2017", "Paid"),
                Invoice("12.50", "Acme Inc.", "82712A", "27-Sep-2017", "Pending"),
                Invoice("722.50", "Google Inc.", "12345G", "12-Sep-2017", "Pending"),
                Invoice("450.00", "Acme Inc.", "45119A", "11-Aug-2017", "Paid"),
                Invoice("2.50", "Google Inc.", "12344G", "12-Jul-2017", "Pending"),
                Invoice("113.00", "Acme Inc.", "44301A", "07-Jul-2017", "Paid"),
                Invoice("513.00", "Facebook Inc.", "44301F", "07-May-2017", "Paid"))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_main, container, false)
        rootView.tag = TAG

        rootView.recycler_invoices.adapter = InvoiceRecyclerViewAdapter(invoices,
                object: InvoiceRecyclerViewAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(rootView.context, "Hello", Toast.LENGTH_LONG).show()
                    }
        })

        return rootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

}// Required empty public constructor
