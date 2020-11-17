package com.example.newsletter.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.newsletter.MainActivity
import com.example.newsletter.NavigationListener
import com.example.newsletter.R


class PageAccueilFragment : Fragment(), RadioGroup.OnCheckedChangeListener {
    private lateinit var button: Button
    private lateinit var li: RadioGroup
    private lateinit var Fr: RadioButton
    private lateinit var Ch: RadioButton
    private lateinit var Et: RadioButton
    private lateinit var An: RadioButton


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.page_accueil, container, false)

        button = view.findViewById(R.id.button)

        li = view.findViewById(R.id.rg_lan)

        Fr = view.findViewById(R.id.Fr)
        Ch = view.findViewById(R.id.Ch)
        Et = view.findViewById(R.id.Et)
        An = view.findViewById(R.id.An)

        li.setOnCheckedChangeListener(this)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            (activity as? NavigationListener)?.let {
                if (Fr.isChecked)   it.changeFragment(FrArticleFragment())
                if (Ch.isChecked)   it.changeFragment(ChArticleFragment())
                if (Et.isChecked)   it.changeFragment(EtArticleFragment())
                if (An.isChecked)   it.changeFragment(AnArticleFragement())
            }
        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        button.isEnabled = Fr.isChecked || Ch.isChecked|| Et.isChecked|| An.isChecked
    }

}

