package com.example.testing.customViews

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.testing.R
import com.example.testing.databinding.PartButtonsBinding

enum class BottomButtonAction{
    POSITIVE,
    NEGATIVE
}

typealias BottomButtonListener = (BottomButtonAction)-> Unit

class BottomButtonsView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: PartButtonsBinding

    private var listener: BottomButtonListener? = null

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)


    init {
//        val inflater = LayoutInflater.from(context)
//        inflater.inflate(R.layout.part_buttons, this, true)
        binding = PartButtonsBinding.inflate(LayoutInflater.from(context), this)
        initializeAttributes(attrs, defStyleAttr, defStyleRes)
        initializeListeners()

    }

    fun initializeAttributes( attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int){
        if(attrs == null) return
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomButtonsView, defStyleAttr, defStyleRes)
        with(binding) {
            val negativeButtonText = typedArray.getString(R.styleable.BottomButtonsView_bottomNegativeButtonText)
            setNegativeBtnTxt(negativeButtonText)

            val positiveButtonText = typedArray.getString(R.styleable.BottomButtonsView_bottomPositiveButtonText)
            setPositiveBtnTxt(positiveButtonText)

            val negativeBtnBgColor = typedArray.getColor(R.styleable.BottomButtonsView_bottomNegativeBackgroundColor,
                Color.RED)

            setNegativeBtnColor(negativeBtnBgColor)

            val positiveBtnBgColor = typedArray.getColor(R.styleable.BottomButtonsView_bottomPositiveBackgroundColor,
                Color.BLUE)

            setPositiveBtnColor(positiveBtnBgColor)


            val isProgressMode = typedArray.getBoolean(R.styleable.BottomButtonsView_bottomProgressMode, false)
            isProgressModeState(isProgressMode)

        }

        typedArray.recycle()
    }


    fun initializeListeners(){
        binding.negativeBtn.setOnClickListener {
            listener?.invoke(BottomButtonAction.NEGATIVE)
        }
        binding.positiveBtn.setOnClickListener {
            listener?.invoke(BottomButtonAction.POSITIVE)
        }
    }

    fun setListener(listener: BottomButtonListener?){
        this.listener = listener

    }

    fun setPositiveBtnTxt(text:String?){
        binding.positiveBtn.text = text ?: "Ok"
    }

    fun setNegativeBtnTxt(text:String?){
        binding.negativeBtn.text = text ?: "Cancel"
    }

    fun setPositiveBtnColor(color:Int){
        binding.positiveBtn.backgroundTintList = ColorStateList.valueOf(color)
    }

    fun setNegativeBtnColor(color:Int){
        binding.negativeBtn.backgroundTintList = ColorStateList.valueOf(color)
    }


    fun isProgressModeState(state: Boolean) = with(binding){
        if(state){
            progressBar.visibility = VISIBLE
            negativeBtn.visibility = INVISIBLE
            positiveBtn.visibility  = INVISIBLE
        }
        else{
            progressBar.visibility = INVISIBLE
            negativeBtn.visibility = VISIBLE
            positiveBtn.visibility  = VISIBLE
        }
    }


    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()!!
        val savedState = SavedState(superState)
        savedState.positiveBtnText = binding.positiveBtn.text.toString()
        savedState.negativeBtnText = binding.negativeBtn.text.toString()
        return savedState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val superState = state as SavedState
        super.onRestoreInstanceState(superState)
        binding.positiveBtn.text = superState.positiveBtnText
        binding.negativeBtn.text = superState.negativeBtnText
    }

    class SavedState: BaseSavedState{
        var positiveBtnText: String? = null
        var negativeBtnText: String? = null

        constructor(superState: Parcelable):super(superState)
        constructor(parcel: Parcel):super(parcel){
             positiveBtnText = parcel.readString()
             negativeBtnText = parcel.readString()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeString(positiveBtnText)
            out.writeString(negativeBtnText)
        }
    }
}