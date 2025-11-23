package com.example.testing.customViews.ticTacToe


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import com.example.testing.R
import androidx.core.content.withStyledAttributes
import kotlin.math.max
import kotlin.math.min

class TicTacToeFieldView(
    val myContext: Context,
    val attr: AttributeSet?,
    val defStyleAttr: Int,
    val defStyleRes: Int
) : View(myContext, attr, defStyleAttr, defStyleRes) {

    var player1Color: Int? = null
    var player2Color: Int? = null
    var fieldColor: Int? = null

    val fieldRect = RectF()
    var cellSize: Float = 0f
    var cellPadding: Float = 0f


    private var player1Paint: Paint? = null
    private var player2Paint: Paint? = null
    private var fieldPaint: Paint? = null

    private var ticTacToeField: TicTacToeField? = null
        set(value) {
            field?.listeners?.remove(listener)
            field = value
            value?.listeners?.add(listener)
            onFieldSizeChanged()
            requestLayout()
            invalidate()
        }

    constructor(context: Context, attr: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attr,
        defStyleAttr,
        0
    )

    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)
    constructor(context: Context) : this(context, null)

    init {
        initializeAttributes(attr, defStyleAttr, defStyleRes)
        initPaints()

        if (isInEditMode) {
            ticTacToeField = TicTacToeField(9, 9)
        }

    }

    private fun initPaints() {
        player1Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        player1Paint?.color = player1Color ?: DEFAULT_PLAYER1_COLOR
        player1Paint?.strokeWidth =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics)
        player1Paint?.style = Paint.Style.STROKE

        player2Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        player2Paint?.color = player2Color ?: DEFAULT_PLAYER2_COLOR
        player2Paint?.strokeWidth =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics)
        player2Paint?.style = Paint.Style.STROKE

        fieldPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        fieldPaint?.color = fieldColor ?: DEFAULT_FIELD_COLOR
        fieldPaint?.strokeWidth =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3f, resources.displayMetrics)
        fieldPaint?.style = Paint.Style.STROKE

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (ticTacToeField == null) return
        drawField(canvas)
        drawCells()
    }

    fun drawField(canvas: Canvas) {

        val fieldColumns = ticTacToeField?.columns ?: 0
        val fieldRows = ticTacToeField?.rows ?: 0

        val yStart = fieldRect.top
        val yEnd = fieldRect.bottom

        for (i in 0..fieldColumns) {
            val x = fieldRect.left + cellSize*i
            canvas.drawLine(
                x,
                yStart,
                x,
                yEnd,
                fieldPaint ?: Paint()
            )

        }

        val xStart = fieldRect.left
        val xEnd = fieldRect.right

        for(i in 0..fieldRows){
            val y = fieldRect.top + cellSize*i
            canvas.drawLine(
                xStart,
                y,
                xEnd,
                y,
                fieldPaint?: Paint()
            )
        }

    }

    fun drawCells() {

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        onFieldSizeChanged()
    }


    fun onFieldSizeChanged() {
        val field = ticTacToeField ?: return

        val safeWidth = width - paddingLeft - paddingRight
        val safeHeight = height - paddingTop - paddingBottom

        val cellWidth = safeWidth / field.columns.toFloat()
        val cellHeight = safeHeight / field.rows.toFloat()

        cellSize = min(cellWidth, cellHeight)
        cellPadding = cellSize * 0.2f

        val fieldWidth = cellSize * field.columns
        val fieldHeight = cellSize * field.rows

        fieldRect.left = paddingLeft + (safeWidth - fieldWidth) / 2
        fieldRect.top = paddingTop + (safeHeight - fieldHeight) / 2
        fieldRect.right = fieldRect.left + fieldWidth
        fieldRect.bottom = fieldRect.top + fieldHeight

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val minHeight = suggestedMinimumHeight + paddingTop + paddingBottom

        val desiredCellInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            DESIRED_CELL_SIZE,
            resources.displayMetrics
        ).toInt()

        val rows = ticTacToeField?.rows ?: 0
        val columns = ticTacToeField?.columns ?: 0

        val desiredWidth = max(minWidth, columns * desiredCellInPixels + paddingLeft + paddingRight)
        val desiredHeight = max(minHeight, rows * desiredCellInPixels + paddingTop + paddingBottom)

        setMeasuredDimension(
            resolveSize(desiredWidth, widthMeasureSpec),
            resolveSize(desiredHeight, heightMeasureSpec)
        )


    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ticTacToeField?.listeners?.add(listener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        ticTacToeField?.listeners?.remove(listener)
    }

    private val listener: onFieldChangeListener = {

    }


    fun initializeAttributes(attr: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attr == null) return
        context.withStyledAttributes(
            attr,
            R.styleable.TicTacToeFieldView,
            defStyleAttr,
            defStyleRes
        ) {

            player1Color =
                getColor(R.styleable.TicTacToeFieldView_player1Color, DEFAULT_PLAYER1_COLOR)
            player2Color =
                getColor(R.styleable.TicTacToeFieldView_player2Color, DEFAULT_PLAYER2_COLOR)
            fieldColor =
                getColor(R.styleable.TicTacToeFieldView_fieldColor, DEFAULT_FIELD_COLOR)


        }
    }


    companion object {

        const val DESIRED_CELL_SIZE = 50f

        const val DEFAULT_PLAYER1_COLOR = Color.GREEN
        const val DEFAULT_PLAYER2_COLOR = Color.RED
        const val DEFAULT_FIELD_COLOR = Color.GRAY
    }
}