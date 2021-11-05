package com.volohov.chucknorrisjokes.bottomnavview.ui.jokes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.volohov.chucknorrisjokes.R
import com.volohov.chucknorrisjokes.api.ApiUtils
import com.volohov.chucknorrisjokes.recyclerview.RecyclerViewAdapter
import io.reactivex.disposables.Disposable

class JokesFragment : Fragment() {

    private val TAG = this::class.java.name

    private var disposable: Disposable? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonJoke: Button
    private lateinit var editTextAmountOfJokes: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jokeArray: ArrayList<String>? = arrayListOf()

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager(context).orientation))

        buttonJoke = view.findViewById(R.id.new_joke)
        editTextAmountOfJokes = view.findViewById(R.id.amount_of_jokes)

        buttonJoke.setOnClickListener {
            disposable = ApiUtils().getNumberOfJokes(
                amountOfJokes = editTextAmountOfJokes.text.toString()
            )
                .subscribe(
                    { response ->
                        for(i in response.value) {
                            jokeArray?.add(i["joke"].toString())
                        }

                        if (jokeArray != null) {
                            recyclerView.adapter = RecyclerViewAdapter(jokeArray.toList())
                        }
                    },
                    { failure ->
                        Log.e(TAG, failure.message.toString())
                    }
                )
        }
    }
}
