using System.Collections;
using System.Collections.Generic;
using System.ComponentModel.Design;
using UnityEngine;

public class Movement : MonoBehaviour
{
    private CharacterController Controller;
    private Vector3 Velocity;
    private bool Cooldown;

    private GameObject LookAt;
    private int Speed;
    public GameObject Cube1;
    public GameObject Cube2;


    private Animator AnimationController;



    private void Start()
    {
            Controller = gameObject.GetComponent<CharacterController>();
            AnimationController = gameObject.GetComponent<Animator>();
    }

    // Update is called once per frame
    private void Update()
    {
        #region Movement
        Velocity.y += -15 * Time.deltaTime;
        if(Input.GetKey("space")&& Cooldown== false){
            AnimationController.SetBool("Fly", true);
            Cooldown = true;
            Velocity.y = Mathf.Sqrt(60);
            StartCoroutine(CooldownRefresh());
        }
        Controller.Move(Velocity*Time.deltaTime);
        #endregion

        #region Tilting
        if(Velocity.y > 0){
            LookAt = Cube1;
            Speed = 5;
        }
        else{
            LookAt = Cube2;
            Speed = 10;
        }

        Quaternion LookOnLook = Quaternion.LookRotation(-LookAt.transform.position - transform.position);
        transform.rotation = Quaternion.Slerp(transform.rotation, LookOnLook, Speed * Time.deltaTime);
        #endregion
    }

    private IEnumerator CooldownRefresh(){
        yield return new WaitForSeconds(0.3f);
        Cooldown = false;
        AnimationController.SetBool("Fly", false);
    }
}
