package org.firstinspires.ftc.teamcode;

public class MathSpline {

    //Variables for Math
    double insideAcos = 0;
    double radiusLeft = 0;
    double radiusRight = 0;

    double alpha = 0; //final x
    double beta = 0; //final y
    double theta = 0; //angle of arc
    double dLeft = 0; //arc length left
    double dRight = 0; //arc length right
    double radius = 0; //radius of robot's COR
    double pLeft = 0; //power of left wheel
    double pRight = 0; //power of right wheel

    //TODO: initiate this variable as the distance in inches from the center of your robot to the center of your wheel
    double midD = 0;


    public void setFinalPose(double xPose, double yPose){
        alpha = xPose;
        beta = yPose;
    }

    //Calculate the needed variables

    public double returnTheta(){
        //radius
        radius = ((alpha * alpha) + (beta * beta)) / (2 * alpha);

        //theta
        insideAcos = (-(alpha * alpha) - (beta * beta)) / (2 * radius * radius);
        double inside = insideAcos + 1;

        theta = Math.acos(inside);

        return theta;
    }

    public double returnDistance(){
        //radius
        radius = ((alpha * alpha) + (beta * beta)) / (2 * alpha);

        //theta
        insideAcos = (-(alpha * alpha) - (beta * beta)) / (2 * radius * radius);
        double inside = insideAcos + 1;

        theta = Math.acos(inside);

        double distance = radius * theta;

        return distance; //dLeft
    }

    public double returnLDistance(){
        //radius
        radius = ((alpha * alpha) + (beta * beta)) / (2 * alpha);

        //left radius
        radiusLeft =  radius + midD;

        //theta
        insideAcos = (-(alpha * alpha) - (beta * beta)) / (2 * radius * radius);
        double inside = insideAcos + 1;

        theta = Math.acos(inside);

        dLeft = radiusLeft * theta;

        return dLeft; //dLeft
    }
    public double returnRDistance(){
        //radius
        radius = ((alpha * alpha ) + (beta * beta )) / (2 * alpha );

        //right radius
        radiusRight = radius - midD;

        //theta
        insideAcos = (-(alpha * alpha) - (beta * beta)) / (2 * radius * radius);
        double inside = insideAcos + 1;

        theta = Math.acos(inside);

        dRight = radiusRight * theta;

        return dRight; //dRight
    }

    public double returnLPower(){
        dLeft = returnLDistance();
        dRight = returnRDistance();

        if (Math.abs(dLeft) > Math.abs(dRight))
            pLeft = 1;
        else
            pLeft = dLeft/dRight;

        return pLeft;
    }
    public double returnRPower(){
        dLeft = returnLDistance();
        dRight = returnRDistance();


        if (Math.abs(dRight) > Math.abs(dLeft))
            pRight = 1;
        else
            pRight = dRight/dLeft;

        return pRight;
    }
}
