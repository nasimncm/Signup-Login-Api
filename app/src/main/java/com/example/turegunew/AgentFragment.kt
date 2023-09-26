package com.example.turegunew

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turegunew.adapter.AgentsAdapter
import com.example.turegunew.api.ApiInterface
import com.example.turegunew.api.RetrofitClient
import com.example.turegunew.models.Agents
import com.example.turegunew.models.AgentsUser
import kotlinx.android.synthetic.main.fragment_agent.*
import kotlinx.android.synthetic.main.fragment_agent.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AgentFragment : Fragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var agentAdapter: AgentsAdapter
    private lateinit var rvRecyclerView: RecyclerView
    private var propertyLists: MutableList<AgentsUser> = ArrayList()
    private lateinit var mProgress: ProgressDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_agent, container, false)

        mProgress = ProgressDialog(context)
        mProgress.setTitle("Processing...")
        mProgress.setMessage("Please wait...")
        mProgress.setCancelable(false)
        mProgress.isIndeterminate

        rvRecyclerView = view.findViewById(R.id.rv_agents)
        propertyLists = ArrayList()
        agentAdapter = AgentsAdapter(requireContext(), propertyLists)
        rvRecyclerView.adapter = agentAdapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        view.rv_agents.layoutManager = linearLayoutManager

        getData()

        return view
    }

    private fun getData() {
        mProgress.show()
        val propertyList = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val retrofitData = propertyList.agents()

        retrofitData.enqueue(object : Callback<Agents> {
            override fun onResponse(
                call: Call<Agents>?,
                response: Response<Agents>?
            ) {
                if (response!!.code() == 200) {
                    val registerResponse: Agents = response.body()!!
                    //  Log.d("onResponse: ", registerResponse.toString())
                    propertyLists.addAll(registerResponse.data.users)
                    rv_agents.adapter = agentAdapter
                    agentAdapter = AgentsAdapter(requireContext(), propertyLists)
                    agentAdapter.notifyDataSetChanged()
                    mProgress.dismiss()
                }

            }

            override fun onFailure(call: Call<Agents>?, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                mProgress.dismiss()
            }
        })
    }
}