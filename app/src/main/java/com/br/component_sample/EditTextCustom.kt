package com.br.component_sample

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

@SuppressLint("CustomViewStyleable")
class EditTextCustom(
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private var imgIcon: AppCompatImageView = AppCompatImageView(context)
    private var swtAvaible: SwitchCompat = SwitchCompat(context)
    private var edtField: AppCompatEditText = AppCompatEditText(context)

    init {
        inflate(context, R.layout.layout_edit_text, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.EditTextCustomized)
        imgIcon = findViewById(R.id.imv_icon)
        swtAvaible = findViewById(R.id.swt_available)
        edtField = findViewById(R.id.edt_field)

        localSetGoneSetup(attributes)

        fieldVisibility()
        localThemeSetup(attributes)

        attributes.recycle()
    }

    private fun localSetGoneSetup(attributes: TypedArray){
        val visibility = attributes.getInt(R.styleable.EditTextCustomized_setVisibility, 0)
        setGoneDescription(visibility)
    }

    fun setGoneDescription(visibility: Int) {
        when (visibility) {
            1 -> swtAvaible.visibility = GONE
            2 -> {
                imgIcon.visibility = GONE
                swtAvaible.visibility = GONE
            }
            3 -> {
                imgIcon.visibility = GONE
                swtAvaible.visibility = GONE
                edtField.visibility = GONE
            }
        }
    }

    private fun localThemeSetup(attributes: TypedArray) {
        val localTheme = attributes.getInt(R.styleable.EditTextCustomized_localTheme, 0)
        setLocalTheme(localTheme)
    }

    fun setLocalTheme(localTheme: Int) {
        when (localTheme) {
            1 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_secondary))
            }
            2 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_error))
            }
            3 -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_primary_variant))
            }
            else -> {
                edtField.setBackgroundColor(ContextCompat.getColor(context, R.color.design_default_color_surface))
            }
        }
    }

    private fun fieldVisibility() {
        swtAvaible.isChecked = true
        swtAvaible.setOnCheckedChangeListener { _ , isChecked ->
            if (isChecked) {
                edtField.visibility = VISIBLE
                imgIcon.visibility = VISIBLE
            } else {
                edtField.visibility = GONE
                imgIcon.visibility = GONE
            }
        }
    }

}